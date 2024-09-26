package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {
    User user;
    private String accountNumber;
    private String accountType;
    double balance;
    Transaction transaction;
    Bank bank;


    public Account(User user, String accountNumber, String accountType, double balance){
        this.user = user;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        bank = new Bank();
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public double deposit(double amount){
        LocalDateTime dateTime = LocalDateTime.now();
        balance = balance + amount;
        transaction = new Transaction(0, amount, balance, dateTime);
        bank.addTransaction(transaction);

        return balance;

    }

    public String withdraw(double amount){
        if(balance > amount){
            LocalDateTime dateTime = LocalDateTime.now();
            balance = balance - amount;
            transaction = new Transaction( amount,0, balance, dateTime);
            bank.addTransaction(transaction);

            return "Balance: " + balance;
        }
        return "Your balance is low to withdraw";

    }





}
