package com.booleanuk.core;

import java.util.Date;

public class Transaction {

    private Date date;
    private double amount;
    private double balance;
    private String typeOfOperation;

    public Transaction(Date date, String typeOfOperation, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.typeOfOperation = typeOfOperation;
    }

    public Date getDate() {
        return date;
    }
    public String getAmount() {
        return String.format("%,.2f", amount);
    }
    public String getBalance() {
        return String.format("%,.2f", balance);
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }
}
