package com.booleanuk.core;

public class SavingsAccount extends BankAccount {
    private final double interest;
    public double getInterest() {
        return interest;
    }
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
        interest = 2.0;
    }
    public SavingsAccount(double initialBalance, double interest) {
        super(initialBalance);
        this.interest = interest;
    }
    @Override
    public boolean withdraw(double amount) {
        //withdrawing from savings account usually is associated with some fee
        if(balance < amount + 5.0)
            return false;
        transactionHistory.add(new Transaction(-amount, 5.0));
        balance -= (amount + 5.0);
        return true;
    }
    public double calculateInterestGain() {
        return balance * (100.0 + interest) / 100.0;
    }
}
