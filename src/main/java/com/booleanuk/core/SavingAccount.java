package com.booleanuk.core;

import java.util.Date;
import java.util.List;

public class SavingAccount implements BankAccount{

    private List<Transaction> transactions;
    private double balance;

    public SavingAccount() {
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
            transactions.add(new Transaction(new Date(), "credit", amount, getBalance()));
            return true;
        }else {
            System.out.println("Amount must be a positive number");
            return false;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && (getBalance() - amount) >= 0) {
            balance -= amount;
            transactions.add(new Transaction(new Date(), "debit", amount, getBalance()));
            return true;
        }
        return false;
    }
}
