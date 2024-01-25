package com.booleanuk.core;

public class Transaction {
    String transactionType;
    String date;
    double amount;
    double balance;

    public Transaction(String transactionType, String date, double amount, double balance) {
        this.transactionType = transactionType;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }
}
