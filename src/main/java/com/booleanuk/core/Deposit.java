package com.booleanuk.core;

import java.time.LocalDate;

public class Deposit implements ITransaction {
    final LocalDate date;
    final double amount;

    public LocalDate date() {return date;}
    public double amount() {return amount;}
    public double signedAmount() {return amount();}

    public Deposit(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public String toString() {
        return String.format(
                "\n%s  || %s       ||              || ",
                date(), amount()
        );
    }
}
