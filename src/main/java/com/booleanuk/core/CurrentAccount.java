package com.booleanuk.core;

public class CurrentAccount implements Account {



    private double balance;

    public CurrentAccount(){
        this.balance = 0.0;
    }
    public CurrentAccount(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
