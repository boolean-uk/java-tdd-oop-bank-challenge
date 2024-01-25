package com.booleanuk.core;

import java.util.ArrayList;

public class Account {

    private String identifier;
    private int balance;
    private ArrayList<Transaction> transactions;

    public Account(String identifier) {
        this.identifier =  identifier;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getBalance() {
        return balance;
        /*
        if(this.transactions.isEmpty()) {
            return 0;
        }
        int balance = 0;
        for(Transaction transaction : transactions) {
            if transaction.getType
        }*/
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }


    public void withdrawal(int amount) {
        if(amount < 0) {return;}
        if(amount > this.balance) {return;}
        try {
            transactions.add(new Transaction(TransactionType.WITHDRAWAL, this, amount));
        } catch(InvalidTransactionTypeException e) {
            System.out.println(e.getMessage());
        }
        this.balance -= amount;

    }

    public void deposit(int amount) {
        if(amount < 0) {return;}
        try {
            transactions.add(new Transaction(TransactionType.DEPOSIT, this, amount));
        } catch(InvalidTransactionTypeException e) {
            return;
        }
        this.balance += amount;


    }

    public String getBankStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%10s || %10s || %10s || %10s \n", "Date", "Type", "Amount", "Balance"));
        for(Transaction transaction : this.transactions) {
            sb.append(String.format(
                    "%10s || %10s || %10s || %10s \n",
                    transaction.getDate().toString(), transaction.getType(),
                    transaction.getAmount(), transaction.getNewBalance()
            ));
        }
        return sb.toString();
    }
}
