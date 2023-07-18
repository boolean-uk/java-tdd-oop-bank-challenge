package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

    private LocalDate dateOfTransaction;
    private double amount;
    private String typeOfTransaction;
    private LocalTime time;
    private double balanceAfterTransaction;


    public Transaction(LocalDate dateOfTransaction, double amount, String typeOfTransaction, LocalTime time, double balanceAfterTransaction) {
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.typeOfTransaction = typeOfTransaction;
        this.time = time;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }


    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        if (typeOfTransaction.equals("credit")) {
            return dateOfTransaction + " || " + amount + "   || " + "        || " + balanceAfterTransaction;
        } else {
            return dateOfTransaction + " || " + "       || " + amount + "    || " + balanceAfterTransaction;
        }
    }
}
