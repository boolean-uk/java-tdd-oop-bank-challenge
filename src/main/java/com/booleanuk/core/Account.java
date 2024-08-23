package com.booleanuk.core;

public abstract class Account {
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

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }

        return "The amount should be positive!";
    }

    public String withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
        return "You dont have enough money for this withdrawal!";
    }

}
