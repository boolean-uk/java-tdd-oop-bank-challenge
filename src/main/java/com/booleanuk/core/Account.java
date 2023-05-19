package com.booleanuk.core;

public class Account {
    String accountNumber, accountHolder, branchCode;
    int balanceInCents;

    public Account(String accountNumber, String accountHolder, String branchCode, int balanceInCents) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.branchCode = branchCode;
        this.balanceInCents = balanceInCents;
    }
}
