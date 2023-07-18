package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    String accountOwner;
    ArrayList<Transaction> transactionHistory;

    public Account(String accountOwner) {
        this.accountOwner = accountOwner;
        this.transactionHistory = new ArrayList<>();
    }

    public void depositMoney(double amountDeposited){
        int deposit = (int) (amountDeposited*100);
        transactionHistory.add(new Transaction(deposit, "deposit"));
    }

    public boolean withdrawMoney(double amountWithdrawn){
        if(amountWithdrawn > calculateBalance())
            return false;

        int withdrawal = (int) (amountWithdrawn*100);
        transactionHistory.add(new Transaction(withdrawal, "withdrawal"));
        return true;
    }

    public double calculateBalance(){
        int balance = 0;
        for (Transaction transaction : transactionHistory){
            balance += transaction.getType().equals("deposit") ? transaction.getAmount() : -transaction.getAmount();
        }
        return (double) balance/100;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
