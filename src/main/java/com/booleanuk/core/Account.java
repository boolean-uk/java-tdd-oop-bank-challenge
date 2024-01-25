package com.booleanuk.core;

public class Account {
    private String accountId;
    private Customer customer;
    private double balance;

    public Account(String accountId, Customer customer) {
        this.accountId = accountId;
        this.customer = customer;
        this.balance = 0.0;
    }

    public String getAccountId() {
        return this.accountId;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public double getBalance() {
        return this.balance;
    }
}
