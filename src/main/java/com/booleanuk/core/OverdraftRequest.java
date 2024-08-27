package com.booleanuk.core;

public class OverdraftRequest {
    private Account account;
    private double requestedLimit;
    private boolean isApproved;

    public OverdraftRequest(Account account, double requestedLimit) {
        this.account = account;
        this.requestedLimit = requestedLimit;
        this.isApproved = false;
    }

    public void approve() {
        this.isApproved = true;
    }

    public void reject() {
        this.isApproved = false;
    }

    public Account getAccount() {
        return this.account;
    }

    public double getRequestedLimit() {
        return this.requestedLimit;
    }

    public boolean isApproved() {
        return this.isApproved;
    }
}
