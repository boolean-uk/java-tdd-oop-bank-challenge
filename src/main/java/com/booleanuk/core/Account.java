package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public abstract class Account {
    private ArrayList<Statement> statements;
    private int id;

    public Account(Customer customer) {
        statements = new ArrayList<>();
        this.id = Objects.hash(customer.getId(), customer.getNoOfCreatedAccounts());
        customer.increaseNoOfCreatedAccounts();
    }

    public double getBalance() {
        double balance = 0;

        for(Statement statement: statements) {
            if(statement instanceof DepositStatement) {
                balance += statement.getAmount();
            } else if(statement instanceof WithdrawStatement) {
                balance -= statement.getAmount();
            }
        }

        return balance;
    }

    public boolean deposit(double amount) {
        if(amount < 0) {
            return false;
        }
        statements.add(new DepositStatement(new Date(), amount));
        return true;
    }

    public boolean withdraw(double amount) {
        if(amount < 0) {
            return false;
        }
        statements.add(new WithdrawStatement(new Date(), amount));
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
        double balance = getBalance();
        for(int i = statements.size()-1; i >= 0; i--) {
            Statement statement = statements.get(i);
            output += statement.toString() + String.format("%.2f",balance);
            output += "\n";
            if(statement instanceof DepositStatement) {
                balance -= statement.getAmount();
            } else if(statement instanceof WithdrawStatement) {
                balance += statement.getAmount();
            }
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
