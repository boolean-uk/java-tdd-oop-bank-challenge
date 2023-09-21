package com.booleanuk.core;

public class Account {

    private double accountNumber;
    private double balance;

    public Account(double accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void depositAmount(double deposit) {
        double newBalance = this.getBalance() + deposit;
        this.setBalance(newBalance);
    }
}
