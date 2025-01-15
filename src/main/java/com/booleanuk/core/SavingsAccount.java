package com.booleanuk.core;

public class SavingsAccount extends BankAccount {
    private double maxOverdraft;

    public SavingsAccount(int branchNumber) {
        super(branchNumber);
        this.maxOverdraft = 0;
    }

    // probably won't be used, but useful in theory
    public boolean hasOverdraft() {
        return maxOverdraft > 0;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public boolean setMaxOverdraft(double maxOverdraft) {
        if (maxOverdraft < 0) {
            System.out.println("Cannot set negative overdraft.");
            return false;
        }
        this.maxOverdraft = maxOverdraft;
        return true;
    }
}
