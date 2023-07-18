package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {

    private LocalDate dateOfTransaction;
    private double amount;
    private String typeOfTransaction;

    public Transaction(LocalDate dateOfTransaction, double amount, String typeOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.typeOfTransaction = typeOfTransaction;
    }
}
