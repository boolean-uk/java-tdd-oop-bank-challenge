package com.booleanuk.core;

public class Transaction {
    private int accNr;
    private String dateTime;
    private double balance;
    private double debit;
    private double credit;
    Customer customer;

    public Transaction(int accNr, String dateTime, double balance, double debit, double credit, Customer customer) {
        this.accNr = accNr;
        this.dateTime = dateTime;
        this.balance = balance;
        this.debit = debit;
        this.credit = credit;
        this.customer = customer;
    }

    public int getAccNr() {
        return accNr;
    }


    public double getBalance() {
        return balance;
    }

    public double getDebit() {
        return debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getDateTime() {
        return dateTime;
    }



}
