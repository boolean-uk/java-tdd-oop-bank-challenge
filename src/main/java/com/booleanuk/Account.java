package com.booleanuk;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public abstract class Account {

    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {}

    public Account(double balance, ArrayList<Transaction> transactions) {
        this.balance = balance;
        this.transactions = new ArrayList<>(transactions);
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public String deposit(double amount) {
        if (amount < 0.0) {
            return "Please enter a valid number";
        }
        balance += amount;
        transactions.add(new Transaction(new Date(), amount, balance, TransactionType.DEPOSIT));
        return "Deposited " + amount;

    }

    public String withdraw(double amount) {
        if (amount < 0.0) {
            return "Please enter a valid number";
        } else if (amount > balance) {
            return "Insufficient quantity. This transaction cannot be completed";
        }
        balance -= amount;
        transactions.add(new Transaction(new Date(), amount, balance, TransactionType.WITHDRAW));
        return "Withdrew " + amount;
    }

    public void generateBankStatement() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-10s || %-10s || %-10s || %-10s%n", "date", "credit", "debit", "balance");
        Collections.reverse(transactions);
        for (Transaction transaction : transactions) {
            String formattedDate = sdf.format(transaction.getTransactionDate());
            double amount = transaction.getAmount();
            double balanceAtTime = transaction.getBalanceAtTime();
            TransactionType type = transaction.getType();

            double creditAmount = type == TransactionType.DEPOSIT ? amount : 0.0;
            double debitAmount = type == TransactionType.WITHDRAW ? amount : 0.0;

            System.out.printf("%-10s || %-10.2f || %-10.2f || %-10.2f%n",
                    formattedDate,
                    creditAmount,
                    debitAmount,
                    balanceAtTime);
        }
    }
}
