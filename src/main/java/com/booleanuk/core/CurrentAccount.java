package com.booleanuk.core;

public class CurrentAccount extends Account {
    public CurrentAccount(String accountName, double maxBalance) {
        super(accountName, maxBalance);
    }

    @Override
    protected int monthlyMaxWithdrawalCount() {
        return -1;
    }
}
