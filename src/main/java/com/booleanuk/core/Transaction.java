package com.booleanuk.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record Transaction(double balanceAfter, Date transactionDate, TransactionType type, double amount) {

    public Transaction {
        if (balanceAfter < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

    public Transaction(double balanceAfter, String transactionDate, TransactionType type, double amount) {
        this(balanceAfter, parseDate(transactionDate), type, amount);
    }

    private static Date parseDate(String transactionDate) {
        if (!transactionDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("Date must be in format dd/mm/yyyy");
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(transactionDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date must be in format dd/mm/yyyy", e);
        }
    }
}
