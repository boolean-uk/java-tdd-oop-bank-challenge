package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public void setDeposit(boolean deposit) {
        isDeposit = deposit;
    }

    private LocalDate date;
    private int amount;
    private boolean isDeposit;
    public Transaction(int amount, boolean isDeposit)
    {
        this.amount = amount;
        this.isDeposit = isDeposit;
        this.date = LocalDate.now();
    }
}
