package com.booleanuk.core;

import java.util.ArrayList;

abstract class Account {
    private String fullName;
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String fullName, String accountNumber) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.setBalance(0.0);
        this.setTransactions(new ArrayList<>());
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {

    }

    public void printStatement() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
