package com.booleanuk.core;

public class CurrentAccount extends Account {
    @Override
    public int deposit(int sum) {
        return 0; // TODO
    }

    @Override
    public int deposit(Transaction transaction) {
        return 0;
    }

    @Override
    public int withdraw(int sum) {
        return 0; // TODO
    }

    @Override
    public int transfer(String targetAccountId, int sum) {
        return 0; // TODO
    }

    @Override
    public String getAccountId() {
        return ""; // TODO
    }

    @Override
    public boolean isCurrentAccount() {
        return true;
    }
}
