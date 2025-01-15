package com.booleanuk.core;

import java.time.LocalDateTime;

public class SavingsAccount extends BankAccount {
    private double maxOverdraft;

    public SavingsAccount(String accountNumber, String branchNumber) {
        super(accountNumber, branchNumber);
        this.maxOverdraft = 0;
    }

    public SavingsAccount(int branchNumber) {
        super(branchNumber);
        this.maxOverdraft = 0;
    }

    @Override
    public boolean withdraw(double amount, LocalDateTime dateTime) {
        if (getBalance() - amount < - maxOverdraft) {
            return false;
        }
        getTransactions().add(new Transaction(-amount, getBalance() - amount, dateTime));
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        return this.withdraw(amount, LocalDateTime.now());
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
