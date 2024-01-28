package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Branch branch;
    private final List<Transaction> transactionHistory;

    public Account(String accountType, double initialAmount, Branch branch) {
        this.transactionHistory = new ArrayList<>();
        this.branch = branch;
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
        return new ArrayList<>(transactionHistory);
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
