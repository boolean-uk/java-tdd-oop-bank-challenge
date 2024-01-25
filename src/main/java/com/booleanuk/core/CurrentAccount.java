package com.booleanuk.core;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(double overdraftLimit) {
        super("Current");
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (amount <= getBalance() || (amount > getBalance() && amount <= (getBalance() + overdraftLimit)))) {
            super.withdraw(amount);
        }
    }

    public void applyOverdraft() {
        if (getBalance() == 0) {
            balance = -overdraftLimit;
        }
    }

    public boolean checkOverdraft() {
        return getBalance() < 0;
    }
}


