package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurrentAccount implements BankAccount{

    private List<Transaction> transactions;
    private double balance;



    public CurrentAccount() {
        transactions = new ArrayList<>();
        this.balance = 0;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            transactions.add(new Transaction(new Date(), amount,getBalance()));
            return true;
        }else {
            System.out.println("Amount must be a positive number");
            return false;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }
}
