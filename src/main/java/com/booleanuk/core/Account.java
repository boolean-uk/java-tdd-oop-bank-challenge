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
        statements.add(new DepositStatement(new Date(), amount, balance));
        return true;
    }

    public boolean withdraw(double amount) {
        if(amount > balance || amount < 0) {
            return false;
        }
        balance -= amount;
        statements.add(new WithdrawStatement(new Date(), amount, balance));
        return true;
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    public int getId() {
        return id;
    }

    //TODO: what to do if very big sum? weird formatting then
    public String generateStatements() {
        String output = "date       || credit  || debit  || balance\n";
        for(int i = statements.size()-1; i >= 0; i--) {
            Statement statement = statements.get(i);
            output += statement.toString() + "\n";
        }
        return output.substring(0, output.length()-1);
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
