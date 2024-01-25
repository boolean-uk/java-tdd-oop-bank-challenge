package com.booleanuk.core;

public class SavingsAccount extends Account {

    private final double minLimit;

    public SavingsAccount(String accountName, int clearingNumber, int accountNumber, double balance) {
        super(accountName, clearingNumber, accountNumber, balance);
        this.minLimit = 0.00;
    }

    public double getMinLimit() {
        return this.minLimit;
    }
}
