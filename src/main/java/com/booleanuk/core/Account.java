package com.booleanuk.core;

import java.util.ArrayList;

public class Account {

    private int id;
    private String type;
    private String branch;
    private ArrayList<Transaction> transactions;
    private int interest;

    public boolean deposit(int amount) {
        if (amount < 1) {
            System.out.println("Amount must be positive.");
            return false;
        }
        Transaction transaction = new Transaction(amount);
        this.transactions.add(transaction);
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount < 1) {
            System.out.println("Amount must be positive.");
            return false;
        }
        Transaction transaction = new Transaction(-amount);
        this.transactions.add(transaction);
        return true;
    }

    public int calcCurrentAmount() {
        int amount = 0;
        for (Transaction transaction : this.transactions) {
            amount += transaction.getAmount();
        }
        return amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }
}
