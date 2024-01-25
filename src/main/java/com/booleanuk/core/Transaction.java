package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime dateTime;
    private int amount;
    private int balance;

    public Transaction(int amount, int balance) {
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getBalance() {
        return this.balance;
    }
}
