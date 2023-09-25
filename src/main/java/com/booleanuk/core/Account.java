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
            System.out.println("Deposit done successfully");
        } else {
            System.out.println("Deposit failed. Amount should be greater than 0.");
        }
    }

    public void withdraw(double amount, Date date) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add(new Transaction(date, 0, amount, balance));
            System.out.println("Withdrawal of " + amount + " completed successfully");
        } else if (amount <= 0) {
            System.out.println("Withdrawal failed. Amount should be greater than 0.");
        } else {
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }
}


