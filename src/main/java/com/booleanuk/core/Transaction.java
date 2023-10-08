package com.booleanuk.core;

public class Transaction {
    private String date;
    private double debit;
    private double credit;
    private double balance;

    public Transaction(String date, double debit, double credit, double balance)
    {
        this.date = date;
        this.debit = debit;
        this.credit = credit;
        this.balance = balance;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDebit()
    {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit()
    {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
