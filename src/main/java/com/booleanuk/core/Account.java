package com.booleanuk.core;

import java.util.*;

public abstract class Account {
    private String accountId;
    private int balance;
    private String branchId;
    private HashMap<Date,Statement> statements;
    AccountsList accountsList = new AccountsList();

    public Account(String branchId) {
        this.branchId = branchId;
        statements = new HashMap<>();
        this.accountId = accountsList.generateAccountId(this.branchId);
    }

    public String getAccountId() {
        return this.accountId;
    }

    public double getBalance() {
        return (double) (this.balance / 100.00);
    }

    public boolean deposit(double amount){
        this.balance += (int) (amount * 100);
        Statement statement = new Statement(amount,balance);
        this.statements.put(statement.getDate(),statement);
        return true;
    }

    public boolean withdraw(double amount) {
        if (this.balance > amount) {
            this.balance -= (int) (amount * 100);
            Statement statement = new Statement(-amount, balance);
            this.statements.put(statement.getDate(), statement);
            return true;
        } else {
            return false;
        }
    }

    public String getStatements() {
        String statementsString = "";
        ArrayList<Date> datesList = new ArrayList<>();
        datesList.addAll(statements.keySet());
        Collections.sort(datesList,Collections.reverseOrder());
        for (Date date: datesList) {
            statementsString += "\n" + statements.get(date).toString();
        }
        return statementsString;
    }

    @Override
    public String toString() {
        return "Account " + accountId + "\nBalance: " + balance;
    }
}
