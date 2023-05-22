package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

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

    public String createAccount(String customerId, Bank.AccountType accountType, double initialBalance) {
        if(!customers.containsKey(customerId)) return Bank.ErrorType.CUSTOMER_NOT_EXISTS.value;

        Account newAccount = Bank.AccountType.CURRENT.equals(accountType) ?
                new CurrentAccount(initialBalance) :
                new SavingsAccount(initialBalance);
        return customers.get(customerId).addAccount(newAccount) ? newAccount.getId() : Bank.ErrorType.ACCOUNT_EXISTS.value;

    }
}
