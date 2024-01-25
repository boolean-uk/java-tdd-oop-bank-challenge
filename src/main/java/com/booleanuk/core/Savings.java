package com.booleanuk.core;

public class Savings implements Account {

    //String accountNumber, String name, double balance
    private String accountNumber;
    private String name;
    private double balance;


    public Savings(String accountNumber, String name, double balance) {

        this.setAccountNumber(accountNumber);
        this.setName(name);
        this.setBalance(balance);


    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}