package com.booleanuk.core;

public class BankAccount {

    private double accountBalance;
    public BankAccount(){
        accountBalance =0.00;

    }

    public boolean deposit(double amount) {
        if(amount > 0) {
            accountBalance += amount;
            return true;
        }else {
            System.out.println("Amount must be a positive number");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        return true;
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
