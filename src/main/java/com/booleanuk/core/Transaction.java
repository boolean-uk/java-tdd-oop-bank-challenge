package com.booleanuk.core;

import java.util.Date;

public class Transaction {

    private Date date;
    private double amount;
    private double balance;
    private String typeOfOperation;

    public Transaction(Date date, String typeOfOperation, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.typeOfOperation = typeOfOperation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
