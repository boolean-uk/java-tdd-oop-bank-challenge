package com.booleanuk.core;

public class SavingsAccount extends Account {

    private final double interest;

    public SavingsAccount(String accNumber, double interest) {
        super(accNumber);
        this.interest = interest;
    }

    public double getInterest() {
        return this.interest;
    }

}
