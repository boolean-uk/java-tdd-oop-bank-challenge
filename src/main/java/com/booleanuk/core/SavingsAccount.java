package com.booleanuk.core;

public class SavingsAccount extends Account {
    SavingsAccount(BankBranch branch) {
        super(branch);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount);
    }
}
