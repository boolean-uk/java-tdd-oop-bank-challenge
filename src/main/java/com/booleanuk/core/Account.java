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

    public boolean depositAmount(double deposit) {
        if (deposit >= 0.00) {
            double newBalance = this.getBalance() + deposit;
            this.setBalance(newBalance);
            return true;
        } else {
            return false;
        }
    }
}
