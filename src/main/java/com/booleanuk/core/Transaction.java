package com.booleanuk.core;

public class Transaction {

    private String date;
    private double credit;
    private double debit;
    private double balance;

    public Transaction(String date, double credit, double debit, double balance) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;

    }
}
