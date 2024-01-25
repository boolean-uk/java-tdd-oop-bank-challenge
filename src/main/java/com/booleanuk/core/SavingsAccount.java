package com.booleanuk.core;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double interestRate) {
        super("Savings");
        this.interestRate = interestRate;
    }

    public void accrueInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    public double checkInterestRate() {
        return interestRate;
    }
}
