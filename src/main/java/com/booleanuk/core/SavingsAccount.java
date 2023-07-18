package com.booleanuk.core;

public class SavingsAccount extends Account {
    @Override
    public boolean withdraw(double amount) {
        //withdrawing from savings account usually is associated with some fee
        if(balance < amount + 5.0)
            return false;
        transactionHistory.add(new Transaction(-amount, 5.0));
        balance -= (amount + 5.0);
        return true;
    }
}
