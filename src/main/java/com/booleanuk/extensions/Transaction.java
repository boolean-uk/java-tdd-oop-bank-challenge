package com.booleanuk.extensions;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private float amount;

    public Transaction(LocalDate date, float amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }
}
