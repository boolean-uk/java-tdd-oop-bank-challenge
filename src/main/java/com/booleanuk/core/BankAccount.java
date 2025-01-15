package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BankAccount {
    private final int accountNumber;
    private double balance;
    private final List<Transaction> transactions;

    public BankAccount() {
        Random random = new Random();
        // account nrs can technically have leading 0s, but i'm not allowing that here
        this.accountNumber = random.nextInt(10000000, 99999999);
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(amount, balance, LocalDateTime.now()));
        }
        return amount <= balance;
    }

    // maybe can be void... or maybe consider overflow?
    public boolean deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(amount, this.balance, LocalDateTime.now()));
        return true;
    }

    public String generateBankStatement() {
        return "";
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
