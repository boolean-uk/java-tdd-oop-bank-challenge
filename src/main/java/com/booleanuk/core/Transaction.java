package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private TransactionType type;
    private int amount;
    private int balance;

    public Transaction(LocalDate date, TransactionType type, double amount,double balance) {
        this.date = date;
        this.type = type;
        this.amount = Util.fromDoubleToInt(amount);
        this.balance = Util.fromDoubleToInt(balance);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
    public double getAmount() {
        return Util.fromIntToDouble(amount);
    }

    public void setAmount(double amount) {
        this.amount = Util.fromDoubleToInt(amount);
    }
    public double getBalance() {
        return Util.fromIntToDouble(balance);
    }

    public void setBalance(double balance) {
        this.balance = Util.fromDoubleToInt(balance);
    }
}
