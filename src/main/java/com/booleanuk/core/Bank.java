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
}
