package com.booleanuk.core;

public abstract class Account {
    protected double balance;
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
        return true;
    }
}
