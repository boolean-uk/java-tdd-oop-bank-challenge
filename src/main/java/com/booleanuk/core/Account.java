package com.booleanuk.core;

import java.util.ArrayList;

abstract class Account {
    private String fullName;
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String fullName, String accountNumber) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.setBalance(0.0);
        this.setTransactions(new ArrayList<>());
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
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        Current currentAccount = new Current("test", "23843898p342");
        currentAccount.deposit(500.0);

        currentAccount.deposit(200.0);
        currentAccount.withdraw(100.0);

        currentAccount.printStatement();
    }
}
