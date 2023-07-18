package com.booleanuk.core;

public class CurrentAccount extends BankAccount{
    private int overdraft = 0;

    @Override
    public void requestOverdraft(double amount){
        overdraft = (int) amount*100;
    }
}
