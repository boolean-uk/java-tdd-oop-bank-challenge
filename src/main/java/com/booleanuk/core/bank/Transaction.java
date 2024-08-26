package com.booleanuk.core.bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private String date;
    private double amount;
    private double balanceBeforeTransaction;
    private Account fromAccount;
    private String id;

    protected Transaction(double amount, double balanceBeforeTransaction, Account fromAccount, String id) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.date = format.format(new Date());
        System.out.println("DATE: " + this.date);
        this.amount = amount;
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        this.fromAccount = fromAccount;
        this.id = id;
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

}
