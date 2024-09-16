package com.booleanuk.core;

public class SavingsAccount extends BankAccount{
    @Override
    public boolean withdraw(double amount) {
        if (amount > this.getBalance()) {
            return false;
        }
        this.transactions.add(new Transaction(amount, false));
        return true;
    }
}
