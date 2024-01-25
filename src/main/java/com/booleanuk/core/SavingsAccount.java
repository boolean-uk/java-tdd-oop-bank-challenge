package com.booleanuk.core;

public class SavingsAccount extends Account {


    public SavingsAccount(String accountName, int clearingNumber, int accountNumber, double balance) {
        super(accountName, clearingNumber, accountNumber, balance);
        this.minLimit = 0.00;
    }
}
