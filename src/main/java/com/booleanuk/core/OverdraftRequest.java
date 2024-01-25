package com.booleanuk.core;

public class OverdraftRequest {
    private Customer customer;
    private Account account;
    private int requestedAmount;
    private boolean approved;

    public OverdraftRequest(Customer customer, Account account, int requestedAmount) {
        this.customer = customer;
        this.account = account;
        this.requestedAmount = requestedAmount;
        this.approved = false;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Account getAccount() {
        return account;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        this.approved = true;
        this.account.limit -= requestedAmount;
    }

    public void reject() {
        this.approved = false;
    }
}