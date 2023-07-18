package com.booleanuk.core;

public class CurrentAccount extends Account {

    CurrentAccount(BankBranch branch) {
        super(branch);
    }

    @Override
    public boolean deposit(double amount) {
        return super.deposit(amount * 0.95);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount * 1.05);
    }
}
