package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Account {
    private double balance;
    private final ArrayList<Transaction> transactions;

    Account() {
        this.balance = 1000.00;
        transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            balance += amount;
            transactions.add(new Transaction(LocalDate.now(), amount, balance));
            return true;
        }
    }

    public boolean withdraw(double amount) {
        amount = -amount;
        if (amount > 0) {
            return false;
        } else {
            balance += amount;
            transactions.add(new Transaction(LocalDate.now(), amount, balance));
            return true;
        }
    }
}
