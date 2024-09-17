package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private TransactionType type;
    private double amount;
    private double balance;

    public Transaction(LocalDate date, double amount, double balance, TransactionType type) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.type = type;

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
