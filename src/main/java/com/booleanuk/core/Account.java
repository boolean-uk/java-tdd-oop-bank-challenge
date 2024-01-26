package com.booleanuk.core;

import java.util.ArrayList;
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

    public String generateStatements() {
        int creditMaxSize = 9;
        int debitMaxSize = 8;

        String[] dates = new String[statements.size()];
        String[] amounts = new String[statements.size()];
        String[] balances = new String[statements.size()];
        boolean[] isDeposit = new boolean[statements.size()];

        double balance = getBalance();

        for(int i = statements.size()-1; i >= 0; i--) {
            int newIndex = statements.size()-1-i;
            Statement statement = statements.get(i);
            balances[newIndex] = String.format("%.2f", balance);
            dates[newIndex] = statement.getDateAsString();
            if(statement instanceof DepositStatement) {
                balance -= statement.getAmount();
                isDeposit[newIndex] = false;
                if(statement.getAmountAsString().length()+2 > creditMaxSize) {
                    creditMaxSize = statement.getAmountAsString().length() + 2;
                }
            } else if(statement instanceof WithdrawStatement) {
                balance += statement.getAmount();
                isDeposit[newIndex] = true;
                if(statement.getAmountAsString().length()+2 > debitMaxSize) {
                    debitMaxSize = statement.getAmountAsString().length() + 2;
                }
            }
            amounts[newIndex] = statement.getAmountAsString();
        }

        String output = "date       || credit" + " ".repeat(creditMaxSize-" credit".length())
                + "|| debit" + " ".repeat(debitMaxSize-" debit".length()) + "|| balance\n";
        for(int i = 0; i < statements.size(); i++) {
            if(isDeposit[i]) {
                output += dates[i] + " ||" + " ".repeat(creditMaxSize) + "|| " + amounts[i] + " ".repeat(debitMaxSize-amounts[i].length()-1) + "|| " + balances[i];
            } else {
                output += dates[i] + " || " + amounts[i] + " ".repeat(creditMaxSize-amounts[i].length()-1) + "||" + " ".repeat(debitMaxSize) + "|| " + balances[i];
            }
            output += "\n";

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
