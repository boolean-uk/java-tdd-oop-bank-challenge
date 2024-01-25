package com.booleanuk.core;

public class Transaction {
    private String time;
    private double amount;

    public Transaction(double amount) {
        this.time = "time";
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }


}
