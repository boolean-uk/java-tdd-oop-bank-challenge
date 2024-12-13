package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate transactionDate;
    private final double amount;
    private final String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
        this.transactionDate = LocalDate.now();
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
