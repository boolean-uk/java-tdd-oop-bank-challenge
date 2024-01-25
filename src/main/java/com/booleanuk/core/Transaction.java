package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final int amount;
    private final boolean isDeposit;
    public Transaction(int amount, boolean isDeposit)
    {
        this.amount = amount;
        this.isDeposit = isDeposit;
        this.date = LocalDate.now();
    }
    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isDeposit() {
        return isDeposit;
    }
}
