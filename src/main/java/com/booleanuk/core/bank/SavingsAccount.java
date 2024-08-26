package com.booleanuk.core.bank;

public class SavingsAccount extends Account {

    private final double interest;

    public SavingsAccount(double interest) {
        super("");
        this.interest = interest;
    }

    public double getInterest() {
        return this.interest;
    }

}
