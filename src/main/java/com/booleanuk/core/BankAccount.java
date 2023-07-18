package com.booleanuk.core;

public abstract class BankAccount {
    protected double balance;
    protected String accountNumber;
    protected final int accountHolderID;

    protected BankAccount(String accountNumber, int accountHolderID) {
        this.accountNumber = accountNumber;
        this.accountHolderID = accountHolderID;
        this.balance = 0.0d;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0.0d) {
            throw new IllegalArgumentException("Cannot deposit a negative amount");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0.0d) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Cannot withdraw more than the balance");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getAccountHolderID() {
        return this.accountHolderID;
    }

}
