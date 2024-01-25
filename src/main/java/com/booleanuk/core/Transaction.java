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
        return date;
    }
    public LocalDateTime setDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        date.format(formatter);
        return this.date = date;
    }
    public double getDebit() {
        return debit;
    }
    public Transaction setDebit(double debit) {
        this.debit = debit;
        return this;
    }
    public double getCredit() {
        return credit;
    }
    public Transaction setCredit(double credit) {
        this.credit = credit;
        return this;
    }
    public double getBalance() {
        return balance;
    }
    public Transaction setBalance(double balance) {
        this.balance = balance;
        return this;
    }
}
