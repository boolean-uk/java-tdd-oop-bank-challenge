package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private double amount;
    private TransactionType transactionType;
    private double balance;

    public Transaction(double amount, TransactionType transactionType, double balance) {
        this.date=LocalDate.now();
        this.amount = amount;
        this.transactionType = transactionType;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
