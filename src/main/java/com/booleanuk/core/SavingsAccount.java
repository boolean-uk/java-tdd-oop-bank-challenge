package com.booleanuk.core;

public class SavingsAccount extends BankAccount {
    private double maxOverdraft;

    public SavingsAccount(int branchNumber) {
        super(branchNumber);
        this.maxOverdraft = 0;
    }

    public boolean hasOverdraft() {
        return maxOverdraft > 0;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public boolean setMaxOverdraft(double maxOverdraft) {
        return true;
    }
}
