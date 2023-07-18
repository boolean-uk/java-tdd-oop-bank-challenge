package com.booleanuk.extension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {

    String accountNumber;
    double balance;
    List<Transaction> transactions;
    String typeOfAccount;

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

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void depositFunds(double amount){
        if(amount < 0){
            throw new RuntimeException("Amount cannot be negative!");
        }
        balance += amount;
        Transaction transaction = new Transaction(LocalDate.now(), amount, "credit", LocalTime.now(), balance);
        transactions.add(transaction);
    }

    public void withdrawFunds(double amount){
        if(amount > balance){
            throw new RuntimeException("You cannot withdraw more than you've got in your account!");
        }
        balance -= amount;
        Transaction transaction = new Transaction(LocalDate.now(), amount, "debit", LocalTime.now(), balance);
        transactions.add(transaction);
    }

}
