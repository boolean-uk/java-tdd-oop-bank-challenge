package com.booleanuk.extensions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account {
    protected List<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
    }
    public void deposit(double amount) {
        transactions.add(new Transaction(new Date(), amount, getBalance() + amount));
    }

    public String withdraw(double amount) {
        if (getBalance() - amount < 0) {
            return "Invalid withdrawal amount or insufficient funds";
        } else {
            transactions.add(new Transaction(new Date(), -amount, getBalance() - amount));
            return "Successfully withdrawn amount";
        }
    }

    public abstract double getBalance();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public abstract void addTransaction(Date date, double amount, double balance);
}