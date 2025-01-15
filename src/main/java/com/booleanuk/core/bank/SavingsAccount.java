package com.booleanuk.core.bank;

public class SavingsAccount extends Account {

    private final double interest;

    public SavingsAccount(Branch branch, double interest) {
        super("", branch);
        this.interest = interest;
    }

    public double getInterest() {
        return this.interest;
    }

}
