package com.booleanuk.core;

public class CurrentAccount extends Account {

    private final double minLimit;

    public CurrentAccount(String accountName, int clearingNumber, int accountNumber, double balance) {
        super(accountName, clearingNumber, accountNumber, balance);
        this.minLimit = -100.00;
    }

    public double getMinLimit() {
        return this.minLimit;
    }
}
