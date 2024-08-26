package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private int id;
    private float balance;
    private float balanceChecker;
    private ArrayList<Transaction> transactionsList;

    public Account(float firstDeposit) {
        this.balanceChecker = firstDeposit;
        this.transactionsList = new ArrayList<>();
        //First initial deposit of account
        Transaction initialTransaction = new Transaction(0, firstDeposit,0);
        transactionsList.add(initialTransaction);
    }

    public void depositMoney(float amount) {
        if(amount > 0) {
            Transaction transaction = new Transaction(transactionsList.size(), amount, 0);

            transactionsList.add(transaction);
            this.balanceChecker += amount;
        }else {
            System.out.println("Cannot add 0 or a negative amount");
        }
    }

    public float getBalance() {
        calculateAccountBalance();
        return this.balance;
    }

    public void withdrawMoney(float amount){
        if(this.balance - amount > 0) {
            Transaction transaction = new Transaction(transactionsList.size(), amount, 1);
            transactionsList.add(transaction);
            this.balanceChecker += amount;
        }else {
            System.out.println("Insufficient amount of transaction.");
        }
    }

    public void calculateAccountBalance() {
        if(!transactionsList.isEmpty()) {
            for (Transaction transaction: transactionsList) {
                this.balance += transaction.getAmount();
            }
        }
    }
}
