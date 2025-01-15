package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private float balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    Transaction deposit(float amount) {
        // amount must be greater than 0
        if (amount <= 0) {
            return null;
        }

        balance += amount;
        Transaction transaction = new Transaction(amount, balance, true);
        transactions.add(transaction);

        return transaction;
    }

    Transaction withdraw(float amount) {
        // amount must be greater than 0 and less than balance
        if (amount <= 0 || amount > balance) {
            return null;
        }

        balance -= amount;
        Transaction transaction = new Transaction(amount, balance, false);
        transactions.add(transaction);

        return transaction;
    }

    float getBalance() {
        return balance;
    }

    ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    String statement() {
        StringBuilder sb = new StringBuilder();

        int cellWidth = 30;
        // format String
        String format = "| %-" + cellWidth + "s | %-" + cellWidth + "s | %-" + cellWidth + "s | %-" + cellWidth
                + "s |%n";
        // add headers
        sb.append(String.format(format, "Date", "Credit", "Debit", "Balance"));

        List<Transaction> descending = transactions.reversed();

        for (Transaction t : descending) {
            String time = t.getTime().toString();
            String amount = String.format("%.2f", t.getAmount());
            String balanceAfter = String.format("%.2f", t.getBalanceAfter());

            // if deposit
            if (t.getIsDeposit()) {
                sb.append(String.format(format, time, amount, "", balanceAfter));
            }
            // if withdraw
            else {
                sb.append(String.format(format, time, "", amount, balanceAfter));
            }
        }

        return sb.toString();
    }
}
