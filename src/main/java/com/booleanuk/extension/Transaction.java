package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    private final double amount;
    private final double fee;
    private final LocalDateTime date;
    public double getAmount() {
        return amount;
    }
    public double getFee() {
        return fee;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public Transaction(double amount) {
        this.amount = amount;
        this.fee = 0.0;
        this.date = LocalDateTime.now();
    }
    public Transaction(double amount, double fee) {
        this.amount = amount;
        this.fee = fee;
        this.date = LocalDateTime.now();
    }
}
