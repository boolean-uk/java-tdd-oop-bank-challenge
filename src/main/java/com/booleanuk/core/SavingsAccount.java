package com.booleanuk.core;

public class SavingsAccount extends Account {


    public SavingsAccount(String accountName, int clearingNumber, int accountNumber) {
        super(accountName, clearingNumber, accountNumber);
        this.minLimit = 0.00;
    }
}
