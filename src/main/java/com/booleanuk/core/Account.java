package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private String accountNumber;
    private double balance;
    private String type;
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance, String type) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.transactions = new ArrayList<>();
    }

    public double addFunds(double amount) {
        balance += amount;

        // Add to history
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        transactions.add(new Transaction(dateTime, amount, 0d, balance));

        return balance;
    }

    public double withdraw(double amount) {

        if (amount > balance) {
            System.out.println("Not enough to withdraw, your balance is: " + balance);
            return balance;
        }
        // Add to history
        balance = balance - amount;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        transactions.add(new Transaction(dateTime, 0, amount, balance));

        return balance;
    }

    public void viewTransaction() {
        System.out.println("Account number: " + getAccountNumber());
        System.out.println("Account type: " + getType()+"\n");

        System.out.printf("%-20s || %-20s || %-20s || %-20s\n", "Date", "Credit", "Debit", "Balance");

        // Showing the newest activity first
        Collections.reverse(transactions);
        for (Transaction transaction : transactions) {
            System.out.printf("%-20s || %-20s || %-20s || %-20s\n", transaction.getDate(), transaction.getCredit(), transaction.getDebit(), transaction.getBalance());
        }
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

    public String getType() {
        return type;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
