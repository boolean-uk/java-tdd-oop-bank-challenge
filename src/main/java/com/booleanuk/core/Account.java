package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Random;

public class Account {
    //Extension: need a branch ID)
    private double balance;
    private ArrayList<Transaction> transactions;
    private final int accountNumber;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public Account() {
        Random rand = new Random();
        //account numbers can't start with 0, but I also think that's the case IRL
        this.accountNumber = rand.nextInt(10000000, 99999999);
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void makeTransaction(double amount) {

    }

    public String generateStatement() {
        return "";
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }



}
