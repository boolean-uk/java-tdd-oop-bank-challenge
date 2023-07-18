package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    private double balance;
    private long accountNumber;
    private List<Transaction> transactions;

    public BankAccount(long accountNumber) {
        this.balance = 0;
        this.accountNumber = accountNumber;
        transactions = new ArrayList<Transaction>();
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            transactions.add(new Transaction(amount, TransactionType.credit, balance + amount));
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance && amount >= 0) {
            transactions.add(new Transaction(amount, TransactionType.debit, balance - amount));
            balance -= amount;
            return true;
        }
        return false;
    }

    public StringBuilder generateStatement() {
        StringBuilder statement = new StringBuilder();
        if(transactions.size()>0) {
            statement.append("|").append(String.format("%-12s|| %15s || %15s || %15s|\n", "    date", "credit     ", "debit     ", "balance    "));
            statement.append("|").append("--------------------------------------------------------------------").append("|").append("\n");
            for (Transaction transaction : transactions
            ) {
                if (transaction.getTransactionType() == TransactionType.debit) {
                    statement.append("|").append(String.format("%-12s|| %15s || %15.2f || %15.2f|\n", transaction.getDate().toString(), "", transaction.getAmount(), transaction.getBalance()));
                    continue;
                }
                statement.append("|").append(String.format("%-12s|| %15.2f || %15.2s || %15.2f|\n", transaction.getDate().toString(), transaction.getAmount(), " ", transaction.getBalance()));
            }
        }
        else {
            statement.append("No Transactions done before");
        }


        return statement;

    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
