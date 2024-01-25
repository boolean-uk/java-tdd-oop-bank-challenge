package com.booleanuk.core;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountName, int clearingNumber, int accountNumber, double balance) {
        super(accountName, clearingNumber, accountNumber, balance);
        this.minLimit = -100.00;
    }
}
