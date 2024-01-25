package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transactions {
    private LocalDate timestamp;
    private double amount;
    private double balance;


    public Transactions(double amount, double balance) {
        this.timestamp = LocalDate.now();
        this.amount = amount;
        this.balance = balance;

    }

    public LocalDate getTimestamp() {
        return timestamp;
    }



    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

}
