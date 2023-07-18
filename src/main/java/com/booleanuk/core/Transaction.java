package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private float credit;
    private float debit;
    private float balance;

    public Transaction(float credit, float debit, float balance) {
        this.date = LocalDate.now();
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getCredit() {
        return credit;
    }

    public float getDebit() {
        return debit;
    }

    public float getBalance() {
        return balance;
    }
}
