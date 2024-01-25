package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Account {

    private int lastAccountNumber = 0;
    private int accountNr;
    private double balance;
    private Map<String, Integer> transactions;

    public Account() {
        this.accountNr = this.lastAccountNumber + 1;
        lastAccountNumber ++;
        this.balance = 0;
        this.transactions = new HashMap<>();
    }

    public void add(double amount){}

    public void remove(double amount){}

    public double getBalance() {
        return balance;
    }

    public Map<String, Integer> getTransactions() {
        return transactions;
    }
}
