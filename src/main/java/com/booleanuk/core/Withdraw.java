package com.booleanuk.core;

import java.time.LocalDate;

public class Withdraw implements ITransaction {
    final LocalDate date;
    final double amount;
    final double balance;

    public LocalDate date() {return date;}
    public double amount() {return amount;}
    public double balance() {return balance;}

    public Withdraw(LocalDate date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance - amount;
    }

    public String toString() {
        return String.format(
                "\n%s  ||             || %s         || %s",
                date(), amount(), balance()
        );
    }
}
