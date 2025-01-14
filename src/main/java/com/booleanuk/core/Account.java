package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private float balance;
    private ArrayList<Transaction> transactions;

    public float getBalance(){
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void withdraw(float amount){
        balance -= amount;
        Transaction transaction = new Transaction(true, balance, amount);
        transactions.add(transaction);
    }

    public void deposit(float amount){
        balance += amount;
        Transaction transaction = new Transaction(false, balance, amount);
        transactions.add(transaction);

    }

    public String generateStatement(){
        List<Transaction> reverse = transactions.reversed();
        return "";
    }

}
