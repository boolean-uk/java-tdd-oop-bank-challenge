package com.booleanuk.core;

public class BankAccount {

    private double accountBalance;
    public BankAccount(){
        accountBalance =0.00;

    }

    public boolean deposit(double amount) {

        return true;
    }

    public boolean withdraw(double amount) {
        return true;
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
