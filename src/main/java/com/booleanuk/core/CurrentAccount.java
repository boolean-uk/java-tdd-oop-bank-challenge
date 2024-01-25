package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount implements Account {

    private ArrayList<Transaction> transactions;
    private double balance;


    @Override
    public double deposit(double amount) {
        return 0;
    }

    @Override
    public double withdraw(double amount) {
        return 0;
    }

    @Override
    public String transactionListToString() {
        return "";
    }

    @Override
    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }
}
