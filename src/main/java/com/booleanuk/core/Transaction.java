package com.booleanuk.core;

public record Transaction(double balanceAfter, String transactionDate, TransactionType type, double amount) {
    public Transaction (double balanceAfter, String transactionDate, TransactionType type, double amount) {
        if (balanceAfter < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balanceAfter = balanceAfter;
        if (!transactionDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("Date must be in format dd/mm/yyyy");
        }
        this.transactionDate = transactionDate;
        this.type = type;
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

}
