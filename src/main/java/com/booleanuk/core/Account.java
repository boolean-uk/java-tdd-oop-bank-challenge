package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Account {

    private float balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

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
        ArrayList<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);
        StringBuilder statement = new StringBuilder();
        statement.append(String.format("%-20s|| %-10s|| %-10s|| %-10s\n", "date", "credit", "debit", "balance"));
        for (Transaction t : reversed){
            statement.append(t.toString()).append("\n");
        }
        return statement.toString();
    }

}
