package com.booleanuk.core;

import java.util.ArrayList;

abstract class Account {
    private String fullName;
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;
    private boolean approvedOverdraft;
    private double overdraftLimit;

    public Account(String fullName, String accountNumber) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.setBalance(0.0);
        this.setTransactions(new ArrayList<>());
        this.approvedOverdraft = false;
        this.overdraftLimit = 0.0;
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.transactions.add(new Transaction(amount, this.getBalance()));
    }

    public void withdraw(double amount) {
        if ((this.balance - amount) > 0.0) {
            this.balance -= amount;
            this.transactions.add(new Transaction(-amount, this.getBalance()));
        }
    }

    public String requestOverdraft(double limit) {

        // Assuming the limit would be somewhere around 1000.
        if (limit > 0 && limit <= 1000) {
            this.approvedOverdraft = true;
            this.overdraftLimit = limit;
            return "Overdraft approved with a limit of: " + limit;
        }
        else {
            return "Max overdraft limit is 1000 in this bank!";
        }
    }

    public void printStatement() {
        String title = "\t ~~~~ TRANSACTION HISTORY ~~~~ ";
        String columnsTitle = String.format("%-10s || %-6s || %-6s || %-6s", "date", "credit", "debit", "balance");
        System.out.println(title + "\n".repeat(2) + columnsTitle);

        for (Transaction transaction : transactions.reversed()) {
            System.out.println(transaction);
        }
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        double balance = 0.0;
        for (Transaction transaction : this.transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
