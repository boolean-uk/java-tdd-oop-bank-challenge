package com.booleanuk.core;

public class CurrentAccount extends BankAccount{
    private boolean allowOverdraft;

    public CurrentAccount() {
        super();
        allowOverdraft = true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > this.getBalance()) {
            if (allowOverdraft) {
                allowOverdraft = false;
            } else {
                return false;
            }
        }
        this.transactions.add(new Transaction(amount, false));
        return true;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        if (!allowOverdraft && this.getBalance() > 0) {
            allowOverdraft = true;
        }
    }
}
