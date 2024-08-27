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
        if(amount <= getBalance()) {
            this.addTransaction(amount, false);
        } else System.out.println("You don't have enough balance");
    }

}
