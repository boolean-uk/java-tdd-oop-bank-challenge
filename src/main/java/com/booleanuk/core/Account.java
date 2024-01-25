package com.booleanuk.core;

import java.util.Date;

public class Account {
    private int balance;
    private int overdraft;
    private StringBuilder transactionLog;
    private Date transactionDate;

    public Account(User user){
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

}
