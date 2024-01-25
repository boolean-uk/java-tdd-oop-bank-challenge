package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account {
    protected double balance;
    protected List<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction(new Date(), amount, balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public String withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction(new Date(), -amount, balance);
            return "Successfully withdrawn amount";
        } else {
            return "Invalid withdrawal amount or insufficient funds";
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public abstract void addTransaction(Date date, double amount, double balance);
}