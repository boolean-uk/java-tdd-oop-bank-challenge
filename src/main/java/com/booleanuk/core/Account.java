package com.booleanuk.core;

import java.util.Date;
import java.util.HashMap;

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
        System.out.println(statement.toString());
        return true;
    }

    public boolean withdraw(double amount) {
        if (this.balance > amount) {
            this.balance -= (int) (amount * 100);
            Statement statement = new Statement(-amount, balance);
            this.statements.put(statement.getDate(), statement);
            System.out.println(statement.toString());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account " + accountId + "\nBalance: " + balance;
    }
}
