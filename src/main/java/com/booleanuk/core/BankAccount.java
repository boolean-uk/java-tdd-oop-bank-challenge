package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

public class BankAccount {
    private static int accountNumberCounter;
    protected int accountNumber;
    protected double balance;
    protected ArrayList<Transaction> transactions;
    protected Branch branch;

    public Branch getBranch() {
        return branch;
    }

    public double getBalance() {
        return balance;
    }

    public BankAccount(Branch branch){
        accountNumber = accountNumberCounter++;
        balance = 0;
        transactions = new ArrayList<>();
        this.branch = branch;
    }

    public void deposit(double amount, LocalDateTime localDateTime){
        balance += amount;
        transactions.add(new Transaction(localDateTime, amount, balance, "+"));

    }

    public void withdraw(double amount, LocalDateTime localDateTime){
        balance -= amount;
        transactions.add(new Transaction(localDateTime, amount, balance, "-"));
    }

    public String generateStatement(){
        StringBuilder statement = new StringBuilder();
        if(transactions.isEmpty()){
            statement = new StringBuilder("No transaction history found");
            return statement.toString();
        }
        for(Transaction transaction : transactions){
            statement.append(transaction.toString());
        }
        return statement.toString();
    }


}
