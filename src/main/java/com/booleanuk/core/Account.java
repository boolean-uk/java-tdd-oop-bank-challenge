package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private String accountNr;
    private String firstName;
    private String lastName;
    private String type;
    private String branch;

    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String accountNr, String firstName, String lastName, String type, String branch, double balance) {
        this.accountNr = accountNr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.branch = branch;
        this.balance = balance;
    }

    // Getters

    public String getAccountNr() {
        return accountNr;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getType() {
        return type;
    }

    public String getBranch() {
        return branch;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addTransactions(double amount) {
        this.transactions.add(new Transaction(amount));
    }
}
