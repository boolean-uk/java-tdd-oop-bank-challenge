package com.booleanuk.core;

public abstract class Account {
    private double balance;
    private final int id;
    public Account(User user){
        this.balance = 0.00;
        this.id = user.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public double withdraw(double debit){
        return this.balance - debit;
    }

    public double deposit(double credit){
        return this.balance + credit;
    }


}
