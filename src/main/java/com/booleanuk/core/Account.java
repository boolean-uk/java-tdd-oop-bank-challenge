package com.booleanuk.core;

public abstract class Account {
    private double balance;
    private final int id;
    public Account(User user){
        this.balance = 0.00;
        this.id = user.getId();
    }

    public double getBalance(){
        return this.balance;
    }

    public void withdraw(double debit){
        this.balance -= debit;
    }

    public void deposit(double credit){
        this.balance += credit;
    }

}
