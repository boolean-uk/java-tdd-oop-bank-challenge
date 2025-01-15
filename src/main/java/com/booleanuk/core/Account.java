package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private double balance = 0;

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    private ArrayList<Transactions> transactions = new ArrayList<>();

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(Account account, double amount) {
        balance += amount;
        String date = java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        Transactions transaction = new Transactions(amount, date, balance, "DEPOSIT");
        transactions.add(transaction);
        return account.getBalance();
    }

    public double withdraw(Account account, double amount) {
        balance -= amount;
        String date = java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm\n"));
        Transactions transaction = new Transactions(amount, date, balance, "WITHDRAW");
        transactions.add(transaction);
        return account.getBalance();
    }

    public String bankStatement() {
        String output = "";
    }
}
