package com.booleanuk.core;

public class SavingsAccount extends Account {

    private final double interest;

    public SavingsAccount(double interest) {
        this.interest = interest;
    }

    public double getInterest() {
        return this.interest;
    }

}
