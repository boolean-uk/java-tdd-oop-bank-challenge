package com.booleanuk.core;

public class SavingAccount implements Account {
    private int balance;

    public SavingAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void generateStatement() {

    }
}
