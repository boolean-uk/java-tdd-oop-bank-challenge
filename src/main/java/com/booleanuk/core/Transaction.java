package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private LocalDate transactionDate;
    private int amount;
    private String type;

    public Transaction(LocalDate transactionDate, int amount, String type) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.type = type;
    }

    public Transaction(int amount, String type) {
        this.amount = amount;
        this.type = type;
        this.transactionDate = LocalDate.now();
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
