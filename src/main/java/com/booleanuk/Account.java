package com.booleanuk;

import java.util.ArrayList;
import java.util.Date;

public abstract class Account {

    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {}

    public Account(double balance, ArrayList<Transaction> transactions) {
        this.balance = balance;
        this.transactions = new ArrayList<>(transactions);
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public String deposit(double amount) {
        return "Not implemented yet";

    }

    public String withdraw(double amount) {
        return "Not implemented yet";
    }

    public String generateBankStatement() {
        return "Not implemented yet";
    }
}
