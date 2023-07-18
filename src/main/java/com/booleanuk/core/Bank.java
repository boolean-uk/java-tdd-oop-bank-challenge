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
}
