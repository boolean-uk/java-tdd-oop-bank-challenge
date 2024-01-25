package com.booleanuk.core;

public class BankStatement {
    private String transactionDate;
    private String type;
    private double amount;
    private double balanceAfter;

    public BankStatement(String date, String type, double amount, double balanceAfter) {
        this.transactionDate = date;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public String getTransactionDate() {
        return this.transactionDate;
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
