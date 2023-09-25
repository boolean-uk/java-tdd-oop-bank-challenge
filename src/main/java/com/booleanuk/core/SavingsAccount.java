package com.booleanuk.core;

public class SavingsAccount extends BankAccount{

    private final String bankType = "savings";

    public SavingsAccount() {

    }

    public SavingsAccount(double balance) {
        super(balance);
    }

    public String getBankType(){
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
