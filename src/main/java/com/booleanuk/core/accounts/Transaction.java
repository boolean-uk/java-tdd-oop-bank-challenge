package com.booleanuk.core.accounts;

import java.time.LocalDateTime;

public class Transaction {
    private double amount;
    private LocalDateTime date;

    private boolean accepted;

    public Transaction(double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public Transaction(double amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
