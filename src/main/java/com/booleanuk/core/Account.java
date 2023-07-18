package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {

    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;
    private String typeOfAccount;

    public Account() {
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.typeOfAccount = "";
    }

    private String generateAccountNumber() {
        int max = 2147483647;
        int min = 1000000000;
        int randomNum = new Random().nextInt(max - min) + min;
        return String.valueOf(randomNum);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void depositFunds(double amount){
        if(amount < 0){
            throw new RuntimeException("Amount cannot be negative!");
        }
        balance += amount;
        Transaction transaction = new Transaction(LocalDate.now(), amount, "credit");
        transactions.add(transaction);
    }

    public void withdrawFunds(double amount){
        if(amount > balance){
            throw new RuntimeException("You cannot withdraw more than you've got in your account!");
        }
        balance -= amount;
        Transaction transaction = new Transaction(LocalDate.now(), amount, "debit");
        transactions.add(transaction);
    }
}
