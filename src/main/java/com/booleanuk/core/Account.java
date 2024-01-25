package com.booleanuk.core;

public class Account {
    private double balance;

    public Account() {
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(int amount) {
        balance += amount;
        return true;
    }
}
