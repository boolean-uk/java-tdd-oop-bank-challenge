package com.booleanuk.core;

import java.util.Date;

public class Account {
    private int balance;
    private int overdraft;
    private StringBuilder transactionLog;
    private Date transactionDate;

    private User user;

    public Account(User user){
        this.user = user;

        this.balance = 0;
        this.overdraft = 0;
        this.transactionLog = new StringBuilder();
        this.transactionDate = new Date();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public StringBuilder getTransactionLog() {
        return transactionLog;
    }

    public void withdraw(int amount){
        setBalance(this.balance - amount);
    }
}
