package com.booleanuk.core;

public class BankStatement {
    private String date;
    private String type;
    private double amount;
    private double balanceAfter;

    public BankStatement(String date, String type, double amount, double balanceAfter) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public String getDate() {
        return this.date;
    }

    public String getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBalanceAfter() {
        return this.balanceAfter;
    }
}
