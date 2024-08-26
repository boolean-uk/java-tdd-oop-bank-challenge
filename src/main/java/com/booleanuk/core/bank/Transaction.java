package com.booleanuk.core.bank;

import java.util.Date;

public class Transaction {

    private Date date;
    private double amount;
    private double balanceBeforeTransaction;
    private Account fromAccount;
    private String id;

    protected Transaction(double amount, double balanceBeforeTransaction, Account fromAccount, String id) {
        this.date = new Date(); // TODO: format?
        this.amount = amount;
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        this.fromAccount = fromAccount;
        this.id = id;
    }

    public Date getDate() {
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
