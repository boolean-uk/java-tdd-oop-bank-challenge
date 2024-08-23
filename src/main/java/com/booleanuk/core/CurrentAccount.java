package com.booleanuk.core;

import java.util.Date;

public class CurrentAccount extends Account{

    private double allowedOverdraft;

    public CurrentAccount(Customer customer) {
        super(customer);
        allowedOverdraft = 0;
    }

    public double getAllowedOverdraft() {
        return allowedOverdraft;
    }

    public boolean setAllowedOverdraft(double allowedOverdraft) {
        if(allowedOverdraft<0) {
            return false;
        }
        this.allowedOverdraft = allowedOverdraft;
        return true;
    }

    public boolean withdraw(double amount) {
        if(amount > this.getBalance()+allowedOverdraft) {
            return false;
        }
        return super.withdraw(amount);
    }
}
