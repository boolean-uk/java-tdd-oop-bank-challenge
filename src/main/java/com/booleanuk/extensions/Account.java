package com.booleanuk.extensions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account {
    protected List<Transaction> transactions;
    private boolean overdraftStatus;
    private boolean overdraftRequested;
    private boolean overdraftAccepted;
    // I can add a variable here called overdraftAmount and set it to -500
    // instead of manually typing -500 in the withdrawal method

    public Account() {
        this.transactions = new ArrayList<>();
        this.overdraftStatus = false;
        this.overdraftRequested = false;
        this.overdraftAccepted = false;
    }

    public void deposit(double amount) {
        transactions.add(new Transaction(new Date(), amount, getBalance() + amount));
    }

    public String withdraw(double amount) {
        if (!overdraftAccepted) {
            if (getBalance() - amount < 0) {
                return "Invalid withdrawal amount or insufficient funds";
            } else {
                transactions.add(new Transaction(new Date(), -amount, getBalance() - amount));
                return "Successfully withdrawn amount";
            }
        } else {
            if (getBalance() - amount < -500) {
                return "Invalid withdrawal amount or insufficient funds";
            } else {
                transactions.add(new Transaction(new Date(), -amount, getBalance() - amount));
                return "Successfully withdrawn amount";
            }
        }
    }

    public abstract double getBalance();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public abstract void addTransaction(Date date, double amount, double balance);

    public boolean getOverdraftStatus() {
        return this.overdraftStatus;
    }

    public void requestOverdraft() {
        if (!overdraftRequested && !overdraftAccepted) {
            overdraftRequested = true;
        } else {
            System.out.println("Overdraft request already made or approved.");
        }
    }

    public boolean getOverdraftRequested() {
        return this.overdraftRequested;
    }

    public void acceptOverdraft() {
        this.overdraftStatus = true;
        this.overdraftAccepted = true;
    }
}