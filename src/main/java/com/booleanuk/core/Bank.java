package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(int id) {
        Customer customer = new Customer(id);
        if (customers.contains(customer)) {
            System.out.println("User exists");
            return false;
        }
        customers.add(customer);
        return true;
    }

    public void addAccount(int customerId, String accountType, int initDeposit) {
        Customer customer = getCustomerById(customerId);
        if (customer == null) {
            return;
        }
        int accountId = getRandomAccountId();
        Account account = new Account(accountId, accountType, initDeposit);
        customer.addAccount(account);
        accounts.add(account);
    }

    private Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }
    private int getRandomAccountId() {
        return accounts.size() + 1;
    }
}
