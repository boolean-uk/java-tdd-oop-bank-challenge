package com.booleanuk.core;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

public class Transaction {

    LocalDate date;
    double balanceAfterTransaction;
    double amount;

    public Transaction(double amount, double balanceAfterTransaction) {
        this.amount =  amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public double getAmount() {
        return amount;
    }
}
