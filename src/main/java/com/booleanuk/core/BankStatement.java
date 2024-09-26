package com.booleanuk.core;

import java.time.LocalDate;
import java.util.Date;

public abstract class BankStatement {

    private LocalDate date;
    private double amount;
    private double balance;


    protected BankStatement(double amount, double balance) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.balance = balance;

    }
    protected LocalDate getTransactionDate() {
        return this.date;
    }

    protected double getAmount() {
        return this.amount;
    }

    protected double getBalance() {
        return this.balance;
    }

    protected abstract String getStatementAsString();
}
