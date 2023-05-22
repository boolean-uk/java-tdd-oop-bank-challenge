package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Branch {

    private String name;
    private Map<String, Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public String createCustomer(){
        Customer customer = new Customer();
        customers.put(customer.getId(), customer);

        return customer.getId();
    }

    public String createAccount(String customerId, Bank.AccountType accountType, double initialBalance) throws IllegalArgumentException{

        if(!customers.containsKey(customerId)) throw new IllegalArgumentException(Bank.ErrorType.CUSTOMER_NOT_EXISTS.value);

        Account newAccount = Bank.AccountType.CURRENT.equals(accountType) ?
                new CurrentAccount(customers.get(customerId), initialBalance) :
                new SavingsAccount(customers.get(customerId), initialBalance);

        return customers.get(customerId).addAccount(newAccount);
    }

    public Map<String, Account> getAllAccounts(){
        Map<String, Account> accountMap = new HashMap<>();
        List<Customer> customers = new ArrayList<>();
        this.customers.values().stream().collect(Collectors.toList()).forEach(customer -> {
            customer.getAccounts().values().forEach(account -> accountMap.put(account.getId(), account));
        });
        return accountMap;
    }

}
