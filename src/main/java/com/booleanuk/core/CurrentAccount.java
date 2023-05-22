package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccount implements BankAccount{
    private List<Transaction> transactions;
    private double balance;

    // Constructors
    public CurrentAccount(){
        this.transactions = new ArrayList<>();
    }

    public CurrentAccount(double balance){
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
        if(transaction.getType().equals("deposit")){
            setBalance(getBalance() + transaction.getAmount());
            getTransactions().add(0,transaction);
        } else if(transaction.getType().equals("withdraw") && getBalance() >= transaction.getAmount()){
            setBalance(getBalance() - transaction.getAmount());
            getTransactions().add(0,transaction);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
