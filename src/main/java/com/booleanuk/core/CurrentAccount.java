package com.booleanuk.core;

public class CurrentAccount {
    private String accountId;
    private Customer customer;
    private double balance;

    public CurrentAccount(String accountId, Customer customer) {
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
