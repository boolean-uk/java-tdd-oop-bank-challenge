package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    LocalDateTime dateTime;
    private int amount;
    private int balance;

    public Transaction(int amount, int balance) {
        this.amount = amount;
        this.balance = balance;
        this.dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return this.dateTime.minusNanos(this.dateTime.getNano());
    }

    public String getDateTimeString() {
        return this.getDateTime().toString().replace("T", " ");
    }

    public int getAmount() {
        return this.amount;
    }

    public int getBalance() {
        return this.balance;
    }
}
