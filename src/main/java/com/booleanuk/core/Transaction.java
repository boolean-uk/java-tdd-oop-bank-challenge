package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime date;
    private double debit;
    private double credit;
    private double balance;

    public Transaction(LocalDateTime date, double debit, double credit, double balance){
        this.date = setDate(date);
        this.debit = debit;
        this.credit = credit;
        this.balance = balance;
    }

    public LocalDateTime getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.date.format(formatter);
        return this.date;
    }
    public LocalDateTime setDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        date.format(formatter);
        return this.date = date;
    }
    public double getDebit() {
        return this.debit;
    }
    public double getCredit() {
        return this.credit;
    }
    public double getBalance() {
        return this.balance;
    }
    public Transaction setBalance(double balance) {
        this.balance = balance;
        return this;
    }
}
