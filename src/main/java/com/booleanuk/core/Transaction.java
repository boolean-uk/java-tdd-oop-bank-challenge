package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transaction {
    String date;
    double amount;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Transaction(double amount) {
        this.date = java.time.LocalDate.now().format(formatter);
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
