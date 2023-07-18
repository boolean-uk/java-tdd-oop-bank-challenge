package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Account {
    private double balance;
    private final ArrayList<Transaction> transactions;

    Account() {
        this.balance = 1000.00;
        transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            balance += amount;
            transactions.add(new Transaction(LocalDate.now(), amount, balance));
            return true;
        }
    }

    public boolean withdraw(double amount) {
        amount = -amount;
        if (amount > 0) {
            return false;
        } else {
            balance += amount;
            transactions.add(new Transaction(LocalDate.now(), amount, balance));
            return true;
        }
    }

    public void printStatement() {
        int width = 15;
        System.out.printf("%-" + width + "s", "Date");
        System.out.printf("%-" + width + "s", "Credit");
        System.out.printf("%-" + width + "s", "Debit");
        System.out.printf("%-" + width + "s", "Balance");
        System.out.println();
        transactions.forEach(transaction -> {
            System.out.printf("%-" + width + "s", transaction.date);
            if (transaction.amount > 0) {
                System.out.printf("%-" + width + "s", transaction.amount);
                System.out.printf("%-" + width + "s", "");
            } else {
                System.out.printf("%-" + width + "s", "");
                System.out.printf("%-" + width + "s", transaction.amount);
            }
            System.out.printf("%-" + width + "s", transaction.balance);
            System.out.println();
        });
    }
}
