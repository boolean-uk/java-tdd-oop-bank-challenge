package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Account {
    protected final LinkedList<Transaction> transactionHistory;
    protected double balance;
    protected final LocalDateTime openDate;
    protected String number;

    public Account() {
        transactionHistory = new LinkedList<Transaction>();
        balance = 0.0;
        openDate = LocalDateTime.now();
        number = "";
    }
    public double getBalance() {
        return balance;
    }
    public LocalDateTime getOpenDate() {
        return openDate;
    }
    public boolean withdraw(double amount) {
        if(balance < amount)
            return false;
        transactionHistory.add(new Transaction(-amount, 0.0));
        balance -= amount;
        return true;
    }
    public void deposit(double amount) {
        transactionHistory.add(new Transaction(amount, 0.0));
        balance += amount;
    }
}
