package com.booleanuk.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
