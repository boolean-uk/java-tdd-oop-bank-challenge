package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private double balance;

    public Account() {
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if(amount < 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if(amount > balance || amount < 0) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public ArrayList<Statement> getStatements() {
        return new ArrayList<>();
    }
}
