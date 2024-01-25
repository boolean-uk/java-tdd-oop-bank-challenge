package com.booleanuk.core;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountName, double maxBalance) {
        super(accountName, maxBalance);
    }

    @Override
    protected int monthlyMaxWithdrawalCount() {
        return 6;
    }
}
