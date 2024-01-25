package com.booleanuk.core;

import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private double balance;

    public Transaction(Date date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBalance() {
        return this.balance;
    }
}
