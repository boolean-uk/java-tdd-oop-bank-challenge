package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    private String accountNumber;
    protected double balance;
    private List<Transaction> history;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.history = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<Transaction> getHistory() {
        return history;
    }

    public void deposit(double amount, Date date) {
        if (amount > 0) {
            balance += amount;
            history.add(new Transaction(date, amount, 0, balance));
            System.out.println("deposit done successfully");
        }
        System.out.println("deposit failed");
    }

    public void withdraw(double amount, Date date) {
    }
}
