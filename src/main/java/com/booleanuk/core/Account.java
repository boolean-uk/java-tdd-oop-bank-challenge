package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(){
        this.accountNumber = UUID.randomUUID().toString();
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
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
}
