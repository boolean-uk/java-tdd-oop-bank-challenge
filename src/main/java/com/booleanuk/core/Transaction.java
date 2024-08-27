package com.booleanuk.core;

public class Transaction {
    private String transactionDate;
    private double transactionAmount;
    private double balanceAtTransaction;

    public Transaction (String transactionDate, double transactionAmount,double balanceAtTransaction){
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.balanceAtTransaction = balanceAtTransaction;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public double getBalanceAtTransaction() {
        return balanceAtTransaction;
    }
}
