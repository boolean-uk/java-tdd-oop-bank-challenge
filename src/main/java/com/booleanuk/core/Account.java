package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private int accNr;
    private double balance;
    private String type;
    private Customer customer;
    ArrayList<Transaction> transactions;
    public Account(int accNr,double balance,String type,Customer customer) {
        this.accNr = accNr;
        this.balance = balance;
        this.type = type;
        this.customer = customer;
        this.transactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getType() {
        return type;
    }

    public int getAccNr() {
        return accNr;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNr=" + accNr +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                ", customer=" + customer +
                ", transactions=" + transactions +
                '}';
    }
}
