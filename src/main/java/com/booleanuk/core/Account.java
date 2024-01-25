package com.booleanuk.core;

import java.util.ArrayList;

abstract public class Account {
    private static int counter = 1;
    private int userID;
    private final int accountID;
    private int overdraft;
    private ArrayList<Integer> activity;

    public Account(){
        accountID = counter;
        counter++;
        overdraft = 0;
        activity = new ArrayList<>();
    }
    public int getUserID(){
        return userID;
    }

    protected void setUserID(int userID){
        this.userID = userID;
    }

    public int getAccountID(){
        return accountID;
    }

    public double getBalance(){
        int balance = 0;
        for (int fund : activity){
            balance += fund;
        }

        return balance;
    }

    public boolean withdraw(int fund){
        if (getBalance() - fund >= overdraft){
            activity.add(-fund);
            return true;
        }
        return false;
    }

    public void deposit(int fund){
        activity.add(fund);
    }
}
