package com.booleanuk.core;

import java.util.UUID;

public class Account {
    String accountNumber;
    double balance;

    public Account(){
        this.accountNumber = UUID.randomUUID().toString();
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
