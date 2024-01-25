package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    LocalDateTime  data;
    double amount;
    double currentBalance;

    public Transaction(LocalDateTime data, double amount, double currentBalance) {
        this.data = data;
        this.amount = amount;
        this.currentBalance = currentBalance;
    }
}
