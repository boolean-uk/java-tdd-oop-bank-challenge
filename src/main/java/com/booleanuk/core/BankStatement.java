package com.booleanuk.core;

import java.text.DateFormat;

public class BankStatement {
    private DateFormat date;
    private double amount;
    private double balanceAfter;

    public BankStatement(DateFormat date, double amount, double balanceAfter) {
        this.date = date;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public DateFormat getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBalanceAfter() {
        return this.balanceAfter;
    }
}
