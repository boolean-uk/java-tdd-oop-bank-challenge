package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountType;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountType) {
        this.accountType = accountType;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
        }
    }

    public double getBalance() {
        return balance;
    }

    public String generateStatement() {
        StringBuilder statement = new StringBuilder("date       || credit  || debit  || balance\n");
        for (Transaction transaction : transactions) {
            statement.append(String.format("%s || %s || %s || %.2f\n",
                    transaction.getDate(), transaction.getCredit(), transaction.getDebit(), transaction.getBalance()));
        }
        return statement.toString();
    }
}