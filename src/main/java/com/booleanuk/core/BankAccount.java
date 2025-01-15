package com.booleanuk.core;

import java.util.ArrayList;

public class BankAccount {
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;

    public BankAccount(Integer uniqueBankNumber, ArrayList<Transaction> listOfTransactions){
        this.uniqueBankNumber = uniqueBankNumber;

        for(Transaction transaction : listOfTransactions){
            this.balance += transaction.getAmount();
        }
        this.balance = Math.round(this.balance * 100.0) / 100.0;
        this.listOfTransactions = listOfTransactions;
    }

    public BankAccount(Integer uniqueBankNumber){
        this.uniqueBankNumber = uniqueBankNumber;
        this.balance = 0D;
        this.listOfTransactions = new ArrayList<Transaction>();
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getUniqueBankNumber() {
        return uniqueBankNumber;
    }

    public ArrayList<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }
}
