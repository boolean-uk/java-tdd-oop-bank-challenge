package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {

    private String type;

    private double amount;

    private LocalDate date;

    private double balance;

    public Transaction(String type, double amount, LocalDate date, double balance) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getBalance() {
        return balance;
    }
}
