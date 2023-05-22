package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccount implements BankAccount{
    private List<Transaction> transactions;
    private double balance;


    public CurrentAccount(){
        this.transactions = new ArrayList<>();
    }

    public CurrentAccount(double balance){
        this.transactions = new ArrayList<>();
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getBalance() {
        return this.balance;
    }

    public void makeTransaction(Transaction transaction) {

    }
}
