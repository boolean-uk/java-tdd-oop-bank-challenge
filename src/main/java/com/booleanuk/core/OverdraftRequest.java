package com.booleanuk.core;

public class OverdraftRequest {
    private Customer customer;
    private CurrentAccount account;
    private double overdraft;

    public OverdraftRequest(Customer customer, CurrentAccount account, double overdraft) {
        this.customer = customer;
        this.account = account;
        this.overdraft = overdraft;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CurrentAccount getAccount() {
        return account;
    }

    public double getOverdraft() {
        return overdraft;
    }
}
