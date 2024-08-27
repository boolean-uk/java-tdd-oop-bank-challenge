package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private int balanceInCents;
    private String amount;

    public Transaction(String amount, int balanceInCents) {
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.balanceInCents = balanceInCents;
    }
    public int getBalanceInCents() {
        return balanceInCents;
    }

    public String getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
