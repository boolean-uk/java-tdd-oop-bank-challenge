package com.booleanuk.core;

public class SavingsAccount extends Account{
    private int balance;
    public SavingsAccount(User user) {
        super(user);
        this.balance = getBalance();
    }
}
