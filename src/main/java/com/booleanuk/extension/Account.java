package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    User user;
    private String accountNumber;
    private String accountType;

    private List<Transaction> transactions;
    LocalDateTime dateTime = LocalDateTime.now();

    public Account(User user, String accountNumber, String accountType) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        transactions.add(new Transaction(dateTime, amount, 0, computeBalance() + amount));
    }

    public void withdraw(double amount) {
        if (amount <= computeBalance()) {
            transactions.add(new Transaction(dateTime, 0, amount, computeBalance() - amount));
        } else {
            System.out.println("Your balance is low to withdraw");
        }
    }

    public double computeBalance() {
        double balance = 0.0;
        for (Transaction t : transactions) {
            balance += t.getCredit() - t.getDebit();
        }
        return balance;
    }

    public String generateBankStatement() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("%-25s", "date"));
        res.append(String.format("%-15s", "credit"));
        res.append(String.format("%-15s", "debit"));
        res.append(String.format("%-15s", "balance"));
        res.append("\n");

        for (Transaction transaction : transactions) {
            res.append(String.format("%-25s", transaction.getDate()));
            res.append(String.format("%-15s", transaction.getCredit()));
            res.append(String.format("%-15s", transaction.getDebit()));
            res.append(String.format("%-15s", transaction.getBalance()));
            res.append("\n");
        }
        return res.toString();
    }

}
