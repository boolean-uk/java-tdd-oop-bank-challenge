package com.booleanuk.core;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountName, int clearingNumber, int accountNumber) {
        super(accountName, clearingNumber, accountNumber);
        this.minLimit = -100.00;
    }
}
