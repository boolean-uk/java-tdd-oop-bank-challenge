package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private String time;
    private double amount;

    public Transaction(double amount) {
        this.time = String.valueOf(LocalDate.now());
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }


}
