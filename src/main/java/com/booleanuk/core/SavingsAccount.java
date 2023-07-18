package com.booleanuk.core;

public class SavingsAccount extends Account{

    public SavingsAccount(String accountNr, Branch branch) {
        super(accountNr, branch);
    }

    @Override
    public void withdraw(int amountOfMoney) {
        if (calculateBalance() >= amountOfMoney) super.withdraw(amountOfMoney);
        else throw new IllegalStateException("You don't have enough money on your account!");
    }
}
