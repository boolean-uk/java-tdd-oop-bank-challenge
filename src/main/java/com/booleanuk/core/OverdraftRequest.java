package com.booleanuk.core;

public class OverdraftRequest {
    private int accountId;
    private int amountRequested;
    private boolean approved;

    public OverdraftRequest(int accountId, int amountRequested) {
        this.accountId = accountId;
        this.amountRequested = amountRequested;
        this.approved = false;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getAmountRequested() {
        return amountRequested;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        this.approved = true;
    }

    public void reject() {
        this.approved = false;
    }
}
