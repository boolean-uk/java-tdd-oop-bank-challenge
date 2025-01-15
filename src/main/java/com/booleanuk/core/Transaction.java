package com.booleanuk.core;

public class Transaction {
    private int ID;
    private String type;
    private double amount;
    private String date;
    private double balanceAfter;

    public Transaction(int ID, String type, double amount, String date, double balanceAfter) {
        this.ID = ID;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.balanceAfter = balanceAfter;
    }

    public int getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }
}
