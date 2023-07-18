package com.booleanuk.core;

import java.time.LocalDateTime;

public class Info {
    private LocalDateTime dateTime;
    private int amount;
    private int balance;
    private int customerId;
    private int accountId;
    private TransactionType transactionType;

    public Info(LocalDateTime transactionDate, int amount, int i, int newBalance, int customerId, int id) {
    }
    public Info(LocalDateTime dateTime, int amount, int balance, int customerId, int accountId, TransactionType transactionType) {
        this.dateTime = dateTime;
        this.amount = amount;
        this.balance = balance;
        this.customerId = customerId;
        this.accountId = accountId;
        this.transactionType = transactionType;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public int getAmount() {
        return amount;
    }
    public int getBalance() {
        return balance;
    }
    public TransactionType getTransactionType() {
        return transactionType;
    }
}
