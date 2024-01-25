package com.booleanuk.core;

public class Transaction {
    private String transactionType;
    private String date;
    private double amount;
    private double balance;

    public Transaction(String transactionType, String date, double amount, double balance) {
        this.transactionType = transactionType;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public String getDate() {
        return this.date;
    }

    public String getAmount() {
        String amount = String.format("%.2f", this.amount);
        return amount;
    }

    public String getBalance() {
        String balance = String.format("%.2f", this.balance);
        return balance;
    }
}
