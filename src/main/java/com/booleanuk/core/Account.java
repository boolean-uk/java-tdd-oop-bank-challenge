package com.booleanuk.core;

import java.util.Date;

public abstract class Account {

    private String accountNumber;
    private double balance;
    private Statement statement;

    public Account() {
        this.statement = new Statement(Account.this);

    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.statement = new Statement(Account.this);
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.statement = new Statement(Account.this);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        addToTransaction("Deposit", amount);

        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            addToTransaction("Withdraw", amount);
            balance -= amount;
        }
    }

    protected void addToTransaction(String type, double amount) {
        Transaction transaction = new Transaction(new Date(), type, amount);

        this.statement.addTransaction(transaction);
    }

}
