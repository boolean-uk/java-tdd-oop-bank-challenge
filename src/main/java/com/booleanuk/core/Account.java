package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {
    protected double balance;
    protected int id;
    protected String accountHolder;
    protected ArrayList<BankStatement> bankStatements;

    public Account(int id, String accountHolder){
        this.id = id;
        this.accountHolder = accountHolder;
        bankStatements = new ArrayList<>();
    }
    public boolean deposit(double amount){
        if(amount < 0){
            return false;
        }
        else{
            balance += amount;
            return true;
        }
    }
    public boolean withdraw(double amount){
        if(amount > balance){
            return false;
        }
        else{
            balance -= amount;
            return true;
        }

    }
    public int getAccountId(){
        return this.id;
    }
}
