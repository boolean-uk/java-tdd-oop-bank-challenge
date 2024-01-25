package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime date;
    private double amount;
    private String type;

    private static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Transaction(double amount, String type) {
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
    }

    public String getDate() {
        return this.date.format(timeFormat);
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
