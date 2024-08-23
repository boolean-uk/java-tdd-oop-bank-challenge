package com.booleanuk.core;

public class Account {
    private String accountID;
    private double balance;


    public Account(double balance) {
        this.accountID = generateRandomAccountId();
        this.balance = balance;

    }

    private String generateRandomAccountId() {
        long randomNumber = (long) (Math.random() * 1_000_000_000_000L);
        return String.format("%012d", randomNumber);
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
