package com.booleanuk.core.bank;

public class Overdraft {

    public static enum OverdraftStatus {
        PENDING,
        APPROVED,
        REJECTED
    }

    private String id;
    private Account account;
    private OverdraftStatus status;
    private double amount;

    public Overdraft(String id, Account account, double amount) {
        this.id = id;
        this.account = account;
        this.status = OverdraftStatus.PENDING;
        this.amount = amount;
    }

    public String getId() {
        return this.id;
    }

    public Account getAccount() {
        return this.account;
    }

    public double getAmount() {
        return this.amount;
    }

    public OverdraftStatus getStatus() {
        return this.status;
    }

    protected void rejectOverdraft() {
        this.status = OverdraftStatus.REJECTED;
    }

    protected void approveOverdraft() {
        this.status = OverdraftStatus.APPROVED;
    }

}
