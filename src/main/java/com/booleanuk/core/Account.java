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
        this.accountNr = this.lastAccountNumber + 1;
        lastAccountNumber ++;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void add(double amount){
        this.transactions.add(new Transaction(amount));
        this.balance += amount;
    }

    public void remove(double amount){
        this.transactions.add(new Transaction(-amount));
        this.balance -= amount;
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
}
