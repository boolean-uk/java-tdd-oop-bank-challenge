package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String date;
    private double credit;
    private double debit;
    private double balance;
    LocalDateTime localDate = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Transaction(LocalDateTime date, double credit, double debit, double balance) {

        this.date = localDate.format(formatter);
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }
    public String getDate() {
        return date;
    }

    public double getCredit() {
        return credit;
    }

    public double getDebit() {
        return debit;
    }

    public double getBalance() {
        return balance;
    }

}
