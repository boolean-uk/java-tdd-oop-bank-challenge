package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private double credit;
    private double debit;

    public double getCredit() {
        return credit;
    }

    public double getDebit() {
        return debit;
    }

    public Transaction(double credit, double debit) {
        this.date = LocalDate.now();
        this.credit = credit;
        this.debit = debit;
    }

    @Override
    public String toString() {

        Account account = new Account();
        return String.format("%s || %.2f || %.2f || %.2f",
                date.toString(), credit, debit, account.calculateBalance());
    }
}