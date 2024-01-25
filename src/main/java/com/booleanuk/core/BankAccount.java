package com.booleanuk.core;

public class BankAccount {

    String accountHolder;
    String accountNumber;
    String accountType;
    String accountBranch;
    double balance;

    public BankAccount(String accountHolder, String accountNumber, String accountType, String accountBranch, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBranch = accountBranch;
        this.balance = 0.00;
    }
}
