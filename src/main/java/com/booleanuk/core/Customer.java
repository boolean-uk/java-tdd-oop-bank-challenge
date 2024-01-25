package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {

    private ArrayList<Account> accounts;
    private int customerId;
    private String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public double deposit(Account account, double amount) {
        return account.deposit(amount);
    }

    public double withdraw(Account account, double amount) {
        return account.withdraw(amount);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
