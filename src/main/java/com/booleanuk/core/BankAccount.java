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
        transactions.add(new Transaction(date, "Deposit", amount, balance + amount));
        balance += amount;
    }

    public void withdraw(double amount, String date) {
        transactions.add(new Transaction(date, "Withdrawal", amount, balance - amount));
        balance -= amount;
    }

    public String generateStatement() {
        // Sort transactions by date in descending order
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


}