package com.booleanuk.core;

public class CurrentAccount extends Account{
    private double balance;
    public CurrentAccount(User user) {
        super(user);
        this.balance = getBalance();
    }
}
