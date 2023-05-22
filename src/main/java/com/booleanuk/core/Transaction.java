package com.booleanuk.core;

import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private double currentBalance;
    private TransactionType type;

    public Transaction(double amount, TransactionType type, double currentBalance) {
        this.date = new Date();
        this.amount = amount;
        this.type = type;
        this.currentBalance = currentBalance;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
