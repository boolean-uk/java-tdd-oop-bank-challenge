package com.booleanuk.core;

public class CurrentAccount extends Account{

    CurrentAccount(String accountNumber, Branch branch) {
        super(accountNumber, branch);
    }

    @Override
    public void deposit(int amount) {
        this.addTransaction(amount, true);
    }

    @Override
    public void withdraw(int amount) {
        this.addTransaction(amount, false);
    }

}
