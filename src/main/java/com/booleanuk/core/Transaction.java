package com.booleanuk.core;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime date;
    private int amount;
    private boolean isCredit;
    private double balance;

    Transaction(LocalDateTime localDateTime, int amount, boolean isCredit) {
        this.date = localDateTime;
        this.amount = amount;
        this.isCredit = isCredit;
        this.balance = balance;

    }

    public void setBalance(double amount) {
        balance = amount;
    }

    public boolean getIsCredit() {
        return isCredit;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(dateFormat);

        return String.format("%7s || %7s || %6s || %6s",
                formattedDate,
                isCredit ? String.format("%.2f", (double) amount) : "",
                isCredit ? "" : String.format("%.2f", (double) amount),
                balance);
    }
}
