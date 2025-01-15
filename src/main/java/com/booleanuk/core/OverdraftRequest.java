package com.booleanuk.core;

public class OverdraftRequest {
    String accountNumber;
    String branchNumber;
    double amount;

    public OverdraftRequest(String accountNumber, String branchNumber, double amount) {
        this.accountNumber = accountNumber;
        this.branchNumber = branchNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public double getAmount() {
        return amount;
    }
}
