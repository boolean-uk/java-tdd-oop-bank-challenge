package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Bank {

    private final Map<UUID, Account> accounts;
    private final Map<UUID, Customer> customers;

    public Bank() {
        this.accounts = new HashMap<>();
        this.customers = new HashMap<>();
    }

    private static boolean isPositive(BigDecimal funds) {
        return funds.compareTo(BigDecimal.ZERO) > 0;
    }

    public UUID registerCustomer() {
        Customer customer = new Customer();
        customers.put(customer.getId(), customer);
        return customer.getId();
    }

    public <T extends Account> UUID openAccount(UUID customerId, Class<T> accountType) {
        if (isCustomer(customerId)) {
            try {
                Customer customer = customers.get(customerId);
                T account = accountType.getDeclaredConstructor(Customer.class).newInstance(customer);
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
            if (isWithdrawable(account, funds)) ;
            account.withdraw(funds);
            return true;
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

    private boolean isWithdrawable(Account account, BigDecimal funds) {
        return funds.compareTo(account.getBalance()) > 0;
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
}
