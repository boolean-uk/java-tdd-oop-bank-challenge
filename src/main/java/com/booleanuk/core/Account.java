package com.booleanuk.core;

import java.util.ArrayList;

public class Account {

    private String identifier;
    private int amount;
    private ArrayList<Transaction> transactions;

    public Account(String identifier) {
        this.identifier =  identifier;
        this.amount = 0;
        this.transactions = new ArrayList<>();
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getAmount() {
        return amount;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void withdrawal(int amount) {

    }

    public void deposit(int amount) {

    }

    public String getBankStatement() {
        return "";
    }
}
