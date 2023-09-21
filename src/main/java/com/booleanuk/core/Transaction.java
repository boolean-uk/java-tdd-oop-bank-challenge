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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
