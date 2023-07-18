package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.*;

public class BankBranch {

    private final Map<UUID, Account> accounts;
    private final Map<UUID, Customer> customers;
    private final String branchId;
    private final Map<UUID, List<Request>> requests;

    public BankBranch(String branchId) {
        this.accounts = new HashMap<>();
        this.customers = new HashMap<>();
        this.branchId = branchId;
        this.requests = new HashMap<>();
    }

    public UUID registerCustomer() {
        Customer customer = new Customer();
        customers.put(customer.getId(), customer);
        return customer.getId();
    }

    public UUID registerCustomer(String phoneNumber) {
        Customer customer = new Customer(phoneNumber);
        customers.put(customer.getId(), customer);
        return customer.getId();
    }

    public <T extends Account> UUID openAccount(UUID customerId, Class<T> accountType) {
        if (isCustomer(customerId)) {
            try {
                Customer customer = customers.get(customerId);
                T account = accountType
                        .getDeclaredConstructor(Customer.class, String.class)
                        .newInstance(customer, branchId);
                accounts.put(account.getId(), account);
                return account.getId();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public boolean deposit(UUID accountId, BigDecimal funds) {
        if (isAccount(accountId) && isPositive(funds)) {
            Account account = accounts.get(accountId);
            account.deposit(funds);
            return true;
        }
        return false;
    }

    public boolean withdraw(UUID customerId, UUID accountId, BigDecimal funds) {
        if (isCustomer(customerId) && isAccount(accountId) && isPositive(funds)) {
            Account account = accounts.get(accountId);
            if (isWithdrawable(account, funds)) {
                account.withdraw(funds);
                return true;
            }
        }
        return false;
    }

    public String generateStatement(UUID customerId, UUID accountId) {
        if (isCustomer(customerId) && isAccount(accountId)) {
            Account account = accounts.get(accountId);
            return account.generateStatement();
        }
        return "";
    }

    public Request requestOverDraft(UUID customerId, UUID accountId, BigDecimal amount) {
        if (isCustomer(customerId) && isAccount(accountId)) {
            Request request = new Request(customerId, accountId, amount);
            List<Request> clientRequests = requests.getOrDefault(customerId, new ArrayList<>());
            clientRequests.add(request);
            requests.put(customerId, clientRequests);
            return request;
        }
        return null;
    }

    public void reviewOverdraftRequest(Request request, Request.Status decision) {
        switch (decision) {
            case ACCEPTED -> {
                request.accept();
                Account account = accounts.get(request.getAccountId());
                account.setAcceptedOverdraft(request.getOverdraftAmount());
            }
            case REJECTED -> {
                request.reject();
            }
        }
        List<Request> clientRequests = requests.get(request.getCustomerId());
        clientRequests.remove(request);
    }

    public String sendStatement(String statement, UUID customerId) {
        if (customers.containsKey(customerId)) {
            Customer customer = customers.get(customerId);
            if (customer.getPhoneNumber() != null) {
                return MessageService.send("Bank statement:\n" + statement, customer);
            }
        }
        return String.format("Message: %s%nTo customer id: %s not sent.", statement, customerId);
    }

    private static boolean isPositive(BigDecimal funds) {
        return funds.compareTo(BigDecimal.ZERO) > 0;
    }

    private boolean isWithdrawable(Account account, BigDecimal funds) {
        return funds.compareTo(account.getBalance().add(account.getAcceptedOverdraft())) <= 0;
    }

    private boolean isCustomer(UUID customerId) {
        return customers.containsKey(customerId);
    }

    private boolean isAccount(UUID accountId) {
        return accounts.containsKey(accountId);
    }

    public Map<UUID, Account> getAccounts() {
        return accounts;
    }

    public Map<UUID, Customer> getCustomers() {
        return customers;
    }

    public List<Request> getRequests(UUID customerId) {
        return requests.get(customerId);
    }
}
