package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final List<Transaction> transactionHistory;

    public Account(String accountType, double initialAmount) {
        this.transactionHistory = new ArrayList<>();
        addTransaction(new Transaction(LocalDateTime.now(), initialAmount, initialAmount, "Credit"));
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public double calculateBalance() {
        double balance = 0;
        for (Transaction transaction : transactionHistory) {
            if ("Credit".equals(transaction.getDebitOrCredit())) {
                balance += transaction.getAmount();
            } else if ("Debit".equals(transaction.getDebitOrCredit())) {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); // Return a copy for immutability
    }
}
