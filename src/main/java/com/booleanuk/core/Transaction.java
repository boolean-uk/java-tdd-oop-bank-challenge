package com.booleanuk.core;

import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private TransactionType type;
    private double balance;

    public Transaction(Date date, double amount, TransactionType type, double balance) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.balance = balance;
    }

    public Date getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getType() {
        return type.toString();
    }

    public double getBalance() {
        return this.balance;
    }
}
