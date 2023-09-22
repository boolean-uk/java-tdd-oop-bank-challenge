package com.booleanuk;

import java.util.Date;

public class Transaction {

    Date transactionDate;
    double amount;
    double balanceAtTime;
    TransactionType type;

    public Transaction() {}

    public Transaction(Date transactionDate, double amount, double balanceAtTime, TransactionType type) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.balanceAtTime = balanceAtTime;
        this.type = type;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalanceAtTime() {
        return balanceAtTime;
    }

    public void setBalanceAtTime(double balanceAtTime) {
        this.balanceAtTime = balanceAtTime;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
