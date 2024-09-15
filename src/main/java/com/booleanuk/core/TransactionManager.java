package com.booleanuk.core;

import java.io.Serializable;
import java.util.ArrayList;

public class TransactionManager implements Serializable {
    private ArrayList<Transaction> transactions;

    public TransactionManager(){
        this.transactions = new ArrayList<>();
    }
    public TransactionManager(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
    public double getBalance(int id){
        double totalBalance = 0;
        for(Transaction transaction : transactions){
            if(transaction.getId() == id){
                totalBalance += transaction.getAmount();
            }
        }
        return totalBalance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
