package com.booleanuk.core;

import java.util.Date;

public abstract class BankStatement {

    private Date date;
    private double amount;
    private double balance;


    protected BankStatement(Date date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;

    }
    protected Date getTransactionDate() {
        return this.date;
    }

    protected double getAmount() {
        return this.amount;
    }

    protected double getBalance() {
        return this.balance;
    }

    protected abstract String getStatementAsString();
}
