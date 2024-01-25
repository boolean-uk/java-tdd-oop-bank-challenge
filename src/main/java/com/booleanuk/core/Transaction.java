package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    LocalDate date;
    int amount;
    boolean isDeposit;
    public Transaction(int amount, boolean isDeposit)
    {
        this.amount = amount;
        this.isDeposit = isDeposit;
        this.date = LocalDate.now();
    }
}
