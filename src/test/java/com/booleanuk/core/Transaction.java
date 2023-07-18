package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    public final LocalDate date;
    public final double amount;
    public final double balance;

    Transaction (LocalDate date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }
}
