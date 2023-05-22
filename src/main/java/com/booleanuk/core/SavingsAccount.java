package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount implements BankAccount{
    private List<Transaction> transactions;
    private double balance;

    // Constructors
    public SavingsAccount(){
        this.transactions = new ArrayList<>();
    }

    public SavingsAccount(double balance){
        this.transactions = new ArrayList<>();
        setBalance(balance);
    }

    // Getters & Setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getBalance() {
        return this.balance;
    }

    // Methods
    public void makeTransaction(Transaction transaction) {

    }
}