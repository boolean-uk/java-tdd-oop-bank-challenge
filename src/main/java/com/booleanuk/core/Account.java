package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    int accountId;
    double balance;
    ArrayList<Transaction> transactions;

    public Account(int accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public double getBalance() {
        return this.balance;
    }
}
