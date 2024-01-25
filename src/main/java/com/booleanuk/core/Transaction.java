package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transaction {
    String date;
    double amount;
    double balance;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Transaction(double amount, double balance) {
        this.date = java.time.LocalDate.now().format(formatter);
        this.amount = amount;
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}
