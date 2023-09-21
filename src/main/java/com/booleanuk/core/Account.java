package com.booleanuk.core;

public class Account {

    private double accountNumber;
    private double balance;

    public Account(double accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
