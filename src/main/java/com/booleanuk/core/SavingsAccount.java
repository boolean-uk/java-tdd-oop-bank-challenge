package com.booleanuk.core;

public class SavingsAccount implements Account {

    private double balance;

    public SavingsAccount(){
        this.balance = 0.0;
    }
    public SavingsAccount(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
