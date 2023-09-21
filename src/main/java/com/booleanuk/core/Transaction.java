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
        return 0.0d;
    }

    public boolean isDeposit() {
        return true;
    }

    public String printData() {
        return "";
    }
}
