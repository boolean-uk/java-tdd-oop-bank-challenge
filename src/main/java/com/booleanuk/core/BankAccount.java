package com.booleanuk.core;

public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private String accountType;
    private String accountBranch;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, String accountType, String accountBranch, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBranch = accountBranch;
        this.balance = 0.00;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountBranch() {
        return accountBranch;
    }

    public void setAccountBranch(String accountBranch) {
        this.accountBranch = accountBranch;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
