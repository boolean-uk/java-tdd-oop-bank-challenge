package com.booleanuk.core;

import java.text.DateFormat;

public class BankStatement {
    private DateFormat date;
    private String type;
    private double amount;
    private double balanceAfter;

    public BankStatement(DateFormat date, String type, double amount, double balanceAfter) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public BankStatement createNewBankStatement(DateFormat date, String type, double amount, double balanceAfter) {
        return new BankStatement(date, type, amount, balanceAfter);
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
