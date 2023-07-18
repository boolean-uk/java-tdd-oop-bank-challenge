package com.booleanuk.core;

public class Account {
    private float balance;

    public Account() {
        this.balance = 0;
    }

    public boolean deposit(float amount){
        if(amount < 0) return false;

        this.balance += amount;
        return true;
    }

    public float checkBalance() {
        return balance;
    }
}
