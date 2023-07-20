package com.booleanuk.core;
import java.util.Date;

public class Transaction {
    private String transactionId;
    private Date date;
    private double amount;

    public Transaction(String transactionId, Date date, double amount) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}

