package com.booleanuk.core;

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

    public UUID registerCustomer() {
        Customer customer = new Customer();
        customers.put(customer.getId(), customer);
        return customer.getId();
    }

    private boolean isCustomer(UUID customerId) {
        return customers.containsKey(customerId);
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

    public Map<UUID, Account> getAccounts() {
        return accounts;
    }
}
