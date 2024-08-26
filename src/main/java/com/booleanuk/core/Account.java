package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {

    private int accountNumber;
    private AccountOwner owner;
    private ArrayList<Transaction> bankStatement;
    private double balance;

    Account(AccountOwner owner){
        this.accountNumber = 12367;
        this.owner = owner;
        this.bankStatement = new ArrayList<>();
        this.balance = 0.00;
    }

    protected double getBalance(){
        return this.balance;
    }

    protected void setBalance(double newBalance){
        this.balance = newBalance;
    }

    protected ArrayList<Transaction> getBankStatement(){
        return this.bankStatement;
    }

    public abstract String deposit(double amount);

    public abstract String withdraw(double amount);



}
