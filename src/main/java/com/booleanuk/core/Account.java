package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account {
    protected int accountNumber;
    protected String password;
    protected static int balance;
    protected static ArrayList<Integer> transactionHistory;
    protected static ArrayList<LocalDateTime> transactionDate;

    public int getTransactionHour(int i) {
        LocalDateTime times = transactionDate.get(i);
        return times.getHour();
    }

    public Account(int accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.password = password;
        this.transactionHistory = new ArrayList<>();
        this.transactionDate = new ArrayList<>();
    }

    public static int Balance() {
        balance = 0;
        for (int i : transactionHistory) {
            balance += i;
        }
        return balance;
    }

    public boolean deposit(int amount) {
        if (amount > 0) {
            transactionHistory.add(amount);
            transactionDate.add(LocalDateTime.now());
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
                transactionDate.add(LocalDateTime.now());
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
