package com.booleanuk.core.accounts;

import com.booleanuk.core.users.Customer;

public class SavingsAccount extends Account{
    private double bankRate;
    public SavingsAccount(Customer user, Double rate) {
        super(user);
        this.bankRate = rate;
    }

    public void earnInterest(){
    }
}
