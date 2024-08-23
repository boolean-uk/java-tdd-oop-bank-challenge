package com.booleanuk.core;

public class SavingsAccount extends Account{

    SavingsAccount(String accountNumber, Branch branch) {
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
