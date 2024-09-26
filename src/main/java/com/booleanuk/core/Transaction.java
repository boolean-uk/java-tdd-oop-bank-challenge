package com.booleanuk.core;

public class Transaction {
    private String date;
    private int amount;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

}
