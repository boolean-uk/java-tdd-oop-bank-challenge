package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    protected int accountNumber;
    protected String password;
    protected int balance;
    protected ArrayList<Integer> transactionHistory;

    public Account(int accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.password = password;
        this.transactionHistory = new ArrayList<>();
    }

    public int Balance() {
        balance = 0;
        for (int i : transactionHistory) {
            balance += i;
        }
        return balance;
    }

    public boolean deposit(int amount) {
        if (amount > 0) {
            transactionHistory.add(amount);
            return true;
        }
        System.out.println("You can't deposit a negative balance!");
        return false;
    }

    public boolean withdraw(int amount) {
        balance = Balance();
        if (amount > 0) {
            if (balance >= amount) {
                int negativeamount = -amount;
                transactionHistory.add(negativeamount);
                System.out.println("You have successfully withdrew " + amount + "$.");
                return true;
            }
            System.out.println("You don't have enough balance to withdraw " + amount + "$.");
            return false;
        }
        System.out.println("You can't withdraw negative balance.");
        return false;
    }

}
