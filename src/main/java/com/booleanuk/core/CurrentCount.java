package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentCount implements Account {
    private int balance;
    private ArrayList <Transaction> transactions;

    public CurrentCount(double balance) {

        this.balance = Util.fromDoubleToInt(balance);
        this.transactions=new ArrayList<Transaction>();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {

        return Util.fromIntToDouble(balance);
    }

    public void setBalance(double balance) {
        this.balance = Util.fromDoubleToInt(balance);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void generateStatement() {

    }

}
