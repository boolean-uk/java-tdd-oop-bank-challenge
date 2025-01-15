package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    private final double amount;
    private final double currentBalance;
    private final LocalDateTime dateTime;

    public Transaction(double amount, double currentBalance, LocalDateTime dateTime) {
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
