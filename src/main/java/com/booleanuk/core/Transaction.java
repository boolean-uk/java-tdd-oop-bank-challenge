package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    public LocalDate date;
    public float amount;

    public Transaction(LocalDate date, float amount) {
        this.date = date;
        this.amount = amount;
    }
}
