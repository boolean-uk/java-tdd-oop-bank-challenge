package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Account {
    private double balance;
    private ArrayList<Statement> statements;
    private int id;

    public Account(Customer customer) {
        balance = 0;
        statements = new ArrayList<>();
        this.id = Objects.hash(customer.getId(), customer.getNoOfCreatedAccounts());
        customer.increaseNoOfCreatedAccounts();
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

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Account)) {
            return false;
        }

        Account other = (Account) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

}
