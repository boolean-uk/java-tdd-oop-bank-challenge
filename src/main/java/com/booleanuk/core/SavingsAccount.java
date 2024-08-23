package com.booleanuk.core;

import java.util.Date;

public class SavingsAccount extends Account {

    public SavingsAccount(Customer customer) {
        super(customer);
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > this.getBalance()) {
            return false;
        }
        return super.withdraw(amount);
    }
}
