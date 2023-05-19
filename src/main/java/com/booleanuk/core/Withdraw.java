package com.booleanuk.core;

import java.time.LocalDate;

public class Withdraw implements ITransaction {
    final LocalDate date;
    final double amount;
    final double balance;

    public Withdraw(LocalDate date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance - amount;
    }

    public String toString() {
        return "";
    }
}
