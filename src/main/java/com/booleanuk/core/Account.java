package com.booleanuk.core;

public abstract class Account {

    private String accountNumber;
    private double balance = 0;

    protected Account(String accNumber) {
        this.accountNumber = accNumber;
    }

    public Account() {

    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    protected void setAccountNumber(String accNumber) {
        this.accountNumber = accNumber;
    }

    protected void deposit(double amount) {
        this.balance += amount;
    }

    protected void withdraw(double amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

}
