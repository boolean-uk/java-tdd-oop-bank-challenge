package com.booleanuk.core;

public class OverdraftRequest {
    private Customer customer;
    private int accountId;
    private double overdraft;

    public OverdraftRequest(Customer customer, int account, double overdraft) {
        this.customer = customer;
        this.accountId = account;
        this.overdraft = overdraft;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getOverdraft() {
        return overdraft;
    }
}
