package com.booleanuk.extension;

import java.time.LocalDateTime;

public class Transaction {
    private final LocalDateTime date;
    private final int amount;
    private final boolean deposit;

    public Transaction(int amount, boolean deposit) {
        this.amount = amount;
        this.deposit = deposit;
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isDeposit() {
        return deposit;
    }
}
