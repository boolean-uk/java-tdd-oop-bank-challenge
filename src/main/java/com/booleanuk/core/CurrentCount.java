package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentCount implements Account {
    private int balance;

    public CurrentCount(int balance) {
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
