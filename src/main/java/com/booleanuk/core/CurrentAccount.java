package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurrentAccount implements BankAccount{

    private List<Transaction> transactions;
    private double balance;
    private boolean canBeOverdrafted;



    public CurrentAccount() {
        transactions = new ArrayList<>();
        this.balance = 0;
        //account can't be overdrafted on creation but can be later
        //be allowed to be overdrafted but maximum amount of overdraft is equal 500
        canBeOverdrafted = false;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    public double getBalance() {
        return Math.round(balance * 100.0) / 100.0;
    }

    @Override
    public boolean deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            transactions.add(new Transaction(new Date(), "credit", amount,getBalance()));
            return true;
        }else {
            System.out.println("Amount must be a positive number");
            return false;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && (getBalance() - amount) >= 0 && canBeOverdrafted == false) {
            balance -= amount;
            transactions.add(new Transaction(new Date(), "debit", amount,getBalance()));
            return true;
        }
        return false;
    }
}
