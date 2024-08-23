package com.booleanuk.core;

public class Account {
    private String accountID;
    private double balance;
    private Customer customer;

    public Account(double balance, Customer customer) {
        this.accountID = generateRandomAccountId();
        this.balance = balance;
        this.customer = customer;
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
