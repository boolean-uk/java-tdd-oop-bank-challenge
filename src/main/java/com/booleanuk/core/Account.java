package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance=0.0;
        this.transactions = new ArrayList<>();
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            Transaction transaction = new Transaction(amount, TransactionType.CREDIT, balance);
            transactions.add(transaction);
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            Transaction transaction = new Transaction(amount, TransactionType.DEBIT, balance);
            transactions.add(transaction);
            return true;
        }
        return false;
    }

    public String getStatement() {
        if(this.transactions.size()==0)
            return "No transactions available.";
        StringBuilder statement = new StringBuilder();
        statement.append("date       || credit  || debit  || balance\n");

        // Sort transactions by date in descending order
        List<Transaction> sortedTransactions = new ArrayList<>(transactions);
        sortedTransactions.sort(Comparator.comparing(Transaction::getDate).reversed());

        // Format and append each transaction to the statement
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Transaction transaction : sortedTransactions) {
            statement.append(dateFormat.format(transaction.getDate())).append(" || ");
            if (transaction.getType() == TransactionType.CREDIT) {
                statement.append(String.format("%.2f", transaction.getAmount())).append(" ||        || ");
            } else {
                statement.append("        || ").append(String.format("%.2f", transaction.getAmount())).append(" || ");
            }
            statement.append(String.format("%.2f", transaction.getCurrentBalance())).append("\n");
        }

        return statement.toString().trim();
    }
}
