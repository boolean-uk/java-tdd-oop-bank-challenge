package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private static int lastAccountNumber = 0;
    private int accountNr;
    //private double balance;
    private Branch branch;
    private List<Transaction> transactions;


    public Account(Branch branch) {
        this.branch = branch;
        this.accountNr = lastAccountNumber + 1;
        lastAccountNumber ++;
        //this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public boolean add(double amount){
        if(amount < 0){
            return false;
        }
        //this.balance += amount;
        System.out.println("Balance: " + this.getBalance() + " Amount " + amount );
        this.transactions.add(new Transaction(amount, this.getBalance() + amount));
        return true;
    }

    public boolean remove(double amount){
        if(amount > this.getBalance() || amount < 0){
            return false;
        }
        //this.balance -= amount;
        this.transactions.add(new Transaction(-amount, this.getBalance() - amount));
        return true;
    }

    public double getBalance() {
        double balance = 0;
        for (Transaction transaction : transactions){
            balance += transaction.getAmount();
        }
        return balance;
        //return balance;
    }

//    public void setBalance(double balance) {
//        this.balance = balance;
//    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getAccountNr() {
        return accountNr;
    }

    public Branch getBranch() {
        return branch;
    }

    //Only for testing purposes
    public static void resetLastAccountNumber() {
        lastAccountNumber = 0;
    }
}
