package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class Account {
    private String branch;
    private String accountType;
    private boolean overDraftEnabled;
    private double overDraftLimit;
    private double balance;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {

    }
    public Account(double balance) {
    this.balance = balance;
    }




    public void depositFunds(double depositAmount){
        LocalDateTime currentDateTime = LocalDateTime.now();
        double balance = this.getBalance();
        Transaction transaction = new Transaction(currentDateTime.toString(), depositAmount, balance);
        this.transactions.add(transaction);
    }

    public double getBalance() {
        double balance = 0.0;
        for (Transaction transaction : this.transactions) {
            balance += transaction.getTransactionAmount();
        }
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
