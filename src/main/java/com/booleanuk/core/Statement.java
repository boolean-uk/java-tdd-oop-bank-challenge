package com.booleanuk.core;

import java.util.Date;

public class Statement {
    private Date date;
    private double amount;
    private double balance;

    public Statement(Date date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}
