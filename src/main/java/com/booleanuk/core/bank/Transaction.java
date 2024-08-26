package com.booleanuk.core.bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    public static enum TransactionType {
        CREDIT,
        DEBIT
    }

    private String date;
    private double amount;
    private double balanceBeforeTransaction;
    private Account fromAccount;
    private String id;
    private TransactionType transactionType;

    protected Transaction(double amount, double balanceBeforeTransaction, Account fromAccount, String id, TransactionType transactionType) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.date = format.format(new Date());
        System.out.println("DATE: " + this.date);
        this.amount = amount;
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        this.fromAccount = fromAccount;
        this.id = id;
        this.transactionType = transactionType;
    }

    public String getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBalanceBeforeTransaction() {
        return this.balanceBeforeTransaction;
    }

    public Account getFromAccount() {
        return this.fromAccount;
    }

    public String getId() {
        return this.id;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

}
