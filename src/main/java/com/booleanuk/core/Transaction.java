package com.booleanuk.core;
import java.time.LocalDateTime;

public record Transaction(double balanceAfter, LocalDateTime transactionDate, TransactionType type, double amount) {

    public Transaction {
        if (balanceAfter < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}
