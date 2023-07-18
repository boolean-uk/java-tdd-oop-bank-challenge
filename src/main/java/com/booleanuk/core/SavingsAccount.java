package com.booleanuk.core;

import java.math.BigDecimal;

public class SavingsAccount extends Account{

    public SavingsAccount(Customer customer, double initialBalance) {
        super(10, 0.25f, BigDecimal.valueOf(initialBalance));
        setCustomer(customer);
    }

    @Override
    public boolean requestOverdraft(double amount) {
        return false;
    }
}
