package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transactions {
    private String type;
    private double amount;
    private LocalDateTime date;

    public Transactions(String type, double amount, LocalDateTime date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
