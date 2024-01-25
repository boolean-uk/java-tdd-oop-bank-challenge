package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {
    int accountNumber;
    User owner;
    private int balance;
    ArrayList<Transaction> transactions;

    public Account(User owner) {
        setOwner(owner);
        setBalance(0);
        setAccountNumber(0);
        this.transactions = new ArrayList<>();
    }

    public boolean deposit(double credit) {
        if(credit > 0) {
            setBalance(toInt(credit));
            return true;
        }
        return false;
    }

    public boolean withdraw(double debit) {
        boolean newBalanceNotLessThanZero = (this.getBalance() - debit) >= 0;
        if(debit > 0 && newBalanceNotLessThanZero) {
            this.setBalance(-toInt(debit));
            return true;
        }
        return false;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return toDouble(balance);
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    private int toInt(Double amount) {
        return (int) Math.round(amount * 100);
    }

    private double toDouble(int amount) {
        return amount / 100.0;
    }

}
