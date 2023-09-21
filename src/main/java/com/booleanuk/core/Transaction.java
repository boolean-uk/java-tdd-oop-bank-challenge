package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String date;
    private final double amount;
    private final boolean isDeposit;

    public Transaction(double amount, boolean isDeposit) {
        this.amount = amount;
        this.isDeposit = isDeposit;
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date = today.format(formatter);
    }

    public double getAmount() {
        return this.amount;
    }

    public boolean isDeposit() {
        return this.isDeposit;
    }

    public String printData() {
        return this.date + " || " + (isDeposit? String.format("%.2f",this.amount) + " ||         || " : "        || " + String.format("%.2f",this.amount) + " || ");
    }
}
