package com.booleanuk.core;

public class SavingAccount implements BankAccount{
    @Override
    public boolean deposit(double amount) {
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }
}
