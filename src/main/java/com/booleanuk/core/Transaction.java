package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private float balance;
    private float amount;

    public Transaction(float amount, int balance) {
        // Make sure returns date in correct format
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.balance =  balance/100f;
    }
    public float getBalance() {
        return balance;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
