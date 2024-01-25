package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Account {
    private static int lastAccountNumber = 0;
    private int accountNr;
    private double balance;
    private List<Transaction> transactions;

    public Account() {
        this.accountNr = lastAccountNumber + 1;
        lastAccountNumber ++;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void add(double amount){
        this.balance += amount;
        this.transactions.add(new Transaction(amount, this.balance));
    }

    public void remove(double amount){
        this.balance -= amount;
        this.transactions.add(new Transaction(-amount, this.balance));
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getAccountNr() {
        return accountNr;
    }

    //Only for testing purposes
    public static void resetLastAccountNumber() {
        lastAccountNumber = 0;
    }
}
