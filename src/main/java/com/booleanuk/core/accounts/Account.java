package com.booleanuk.core.accounts;

import com.booleanuk.core.Transaction;

import java.util.ArrayList;

abstract class Account {
    private String fullName;
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String fullName, String accountNumber) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {

    }

    public void withdraw(double amount) {

    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void printStatement() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
