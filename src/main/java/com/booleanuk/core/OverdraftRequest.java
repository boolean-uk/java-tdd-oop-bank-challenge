package com.booleanuk.core;

public class OverdraftRequest {

    private int accountId;
    private Bank.OverdraftStatus status;

    public OverdraftRequest(int accountId, Bank.OverdraftStatus status) {
        this.accountId = accountId;
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Bank.OverdraftStatus getStatus() {
        return status;
    }

    public void setStatus(Bank.OverdraftStatus status) {
        this.status = status;
    }
}
