package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    private double balance;
    private long accountNumber;
    private List<Transaction> transactions;

    public BankAccount(long accountNumber) {
        this.balance = 0;
        this.accountNumber = accountNumber;
        transactions = new ArrayList<Transaction>();
    }
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
    public boolean withdraw(double amount) {
        if (amount <= balance && amount>=0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public StringBuilder generateStatement() {
        return new StringBuilder();
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
