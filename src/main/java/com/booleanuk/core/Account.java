package com.booleanuk.core;

abstract public class Account {
    private static int counter = 1;
    private int userID;
    private final int accountID;
    private int balance;

    public Account(){
        balance = 0;
        accountID = counter;
        counter++;
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
        return balance;
    }
}
