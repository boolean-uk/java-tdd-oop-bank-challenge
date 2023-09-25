package com.booleanuk.core;

public class CurrentAccount extends BankAccount {
    private final String bankType = "current";


    public CurrentAccount() {

    }

    public CurrentAccount(double balance) {
        super(balance);
    }

    public String getBankType() {
        return bankType;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount >= 0) {
            balance +=amount;
            return true;
        } else {
            return false;
        }
    }


}
