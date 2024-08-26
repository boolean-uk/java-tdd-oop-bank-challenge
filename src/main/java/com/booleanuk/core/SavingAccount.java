package com.booleanuk.core;

public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(double balance, double interestRate, Branch branch) {
        super(balance, branch);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate/100);
        deposit(interest);

    }
}
