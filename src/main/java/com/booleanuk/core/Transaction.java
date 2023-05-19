package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private TransactionType type;
    private int balance;
    private int amount;

    public Transaction(LocalDate date, TransactionType type, int balance, int amount) {
        this.date = date;
        this.type = type;
        this.balance = balance;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
