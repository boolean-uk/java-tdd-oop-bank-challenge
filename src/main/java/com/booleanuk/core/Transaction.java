package com.booleanuk.core;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Transaction {
    private Date date;
    private String type;
    private double amount;
    private double balance;

    public Transaction(String date, String type, double amount) {
        try {
            this.date = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.type = type;
        this.amount = amount;

    }

    public String getDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}
