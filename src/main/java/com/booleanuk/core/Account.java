package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final List<Transaction> transactions;
    private double overdraftLimit;
    private boolean overdraftAllowed;

    public Account() {

        this.transactions = new ArrayList<>();
        this.overdraftLimit = 0.0;
        this.overdraftAllowed = false;
    }

    public void deposit(double amount){

        this.transactions.add(new Transaction(amount, 0));

    }

    public void withdraw(double amount){

        if (overdraftAllowed && (calculateBalance() - amount >= -overdraftLimit)) {

            this.transactions.add(new Transaction(0, amount));

        } else {

            System.out.println("Insufficient funds");

        };

    }

    public double calculateBalance(){

        double balance = 0;
        for (Transaction transaction : transactions){
            balance += transaction.getCredit() - transaction.getDebit();
        }

        return balance;

    }

    public List<Transaction> getTransactions() {

        return transactions;

    }

    public void approveOverdraft(double limit) {

        this.overdraftAllowed = true;
        this.overdraftLimit = limit;

    }


}

