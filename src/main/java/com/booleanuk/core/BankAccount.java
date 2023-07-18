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

    public void deposit(double amount) throws IllegalArgumentException {} // TODO

    public void withdraw(double amount) throws IllegalArgumentException {} // TODO

}
