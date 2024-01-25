package com.booleanuk.core;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class BankAccount {
    private String accountType;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountType) {
        this.accountType = accountType;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount, String date) {
        balance += amount;
        transactions.add(new Transaction(date, "Deposit", amount));
    }

    public void withdraw(double amount, String date) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(date, "Withdrawal", amount));
        } else {
            // Handle insufficient funds
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public String generateStatement() {

        transactions.sort(Comparator.comparing(Transaction::getDate).reversed());

        StringBuilder statement = new StringBuilder("date       || credit  || debit  || balance\n");
        for (Transaction transaction : transactions) {
            statement.append(String.format("%s || %s || %s || %.2f\n",
                    transaction.getDate(),
                    (transaction.getType().equals("Deposit") ? String.format("%.2f", transaction.getAmount()) : ""),
                    (transaction.getType().equals("Withdrawal") ? String.format("%.2f", transaction.getAmount()) : ""),
                    transaction.getBalance()));
        }
        return statement.toString().trim();
    }

    public String getAccountType() {
        return accountType;
    }
    public double getBalance() {
        return balance;
    }
}