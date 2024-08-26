package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private int id;
    private float balance;
    private ArrayList<Transaction> transactionsList;

    public Account(float firstDeposit) {
        this.balance = firstDeposit;
        this.transactionsList = new ArrayList<>();
    }

    public void depositMoney(float amount) {
        if(amount > 0) {
            Transaction transaction = new Transaction(transactionsList.size(), amount, 0);

            transactionsList.add(transaction);
            this.balance += amount;
        }else {
            System.out.println("Cannot add 0 or a negative amount");
        }
    }

    public float getBalance() {
        return this.balance;
    }

    public void withdrawMoney(float amout){
        if(this.balance - amout > 0) {
            Transaction transaction = new Transaction(transactionsList.size(), amout, 1);
            transactionsList.add(transaction);
            this.balance -= amout;
        }else {
            System.out.println("Insufficient amount of transaction.");
        }
    }
}
