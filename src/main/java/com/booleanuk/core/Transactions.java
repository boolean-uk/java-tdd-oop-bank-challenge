package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transactions {
    private double amount;
    private String date;
    private double balance;
    private String type;


    public Transactions(double amount, String date, double balance, String type) {
        this.amount = amount;
        this.type = type;
        this.balance = balance;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }
}
