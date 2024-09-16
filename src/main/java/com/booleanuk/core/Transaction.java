package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    LocalDateTime dateTime;
    double amount;

    public Transaction(double amount) {
        this.dateTime = LocalDateTime.now();
        this.amount = amount;
    }
}
