package com.booleanuk.core;

public class Account {
    double balance;
    Customer customer;
    public Account(double balance,Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
