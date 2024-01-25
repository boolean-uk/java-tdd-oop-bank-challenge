package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private double credit;
    private double debit;
    private double balance;

    public Transaction(double credit, double debit, double balance) {
        this.setDate();
        this.setCredit(credit);
        this.setDebit(debit);
        this.setBalance(balance);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
