package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Account {
    private double balance;
    private ArrayList<Statement> statements;

    public Account() {
        balance = 0;
        statements = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if(amount < 0) {
            return false;
        }
        balance += amount;
        statements.add(new Statement(new Date(), amount, balance));
        return true;
    }

    public boolean withdraw(double amount) {
        if(amount > balance || amount < 0) {
            return false;
        }
        balance -= amount;
        statements.add(new Statement(new Date(), amount, balance));
        return true;
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }
}
