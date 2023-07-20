package com.booleanuk.core;

public class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }
}
