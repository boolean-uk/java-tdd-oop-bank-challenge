package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account {
    protected int accountNumber;
    protected String password;
    protected static int balance;
    protected static ArrayList<Integer> transactionHistory;
    protected static ArrayList<LocalDateTime> transactionDate;
    protected boolean isOverdraft;
    protected int OverdraftLimit = 2000;

    public int getTransactionHour(int i) {
        LocalDateTime times = transactionDate.get(i);
        return times.getHour();
    }

    public Account(int accountNumber, String password) {
        this.accountNumber = accountNumber;
        balance = 0;
        this.password = password;
        transactionHistory = new ArrayList<>();
        transactionDate = new ArrayList<>();
        this.isOverdraft = false;
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
            System.out.println("Successfully deposited " + amount + "$.");
            return true;
        }
        System.out.println("You can't deposit a negative balance!");
        return false;
    }

    public boolean withdraw(int amount) {
        balance = Balance();
        if (amount > 0) {
            if (balance >= amount) {
                int negativeAmount = -amount;
                transactionHistory.add(negativeAmount);
                transactionDate.add(LocalDateTime.now());
                System.out.println("You have successfully withdrew " + amount + "$.");
                return true;
            }
            else if (isOverdraft) {
                if (-(balance - amount) < OverdraftLimit){
                    int negativeAmount = -amount;
                    transactionHistory.add(negativeAmount);
                    transactionDate.add(LocalDateTime.now());
                    System.out.println("You have successfully withdrew " + amount + "$.");
                    return true;
                }
                System.out.println("You don't have enough balance to withdraw " + amount + "$.");
                return false;
            }
            System.out.println("You don't have enough balance to withdraw " + amount + "$.");
            return false;
        }
        System.out.println("You can't withdraw negative balance.");
        return false;
    }

    public boolean Overdraft(boolean request) {
        isOverdraft = request;
        return isOverdraft;
    }
}
