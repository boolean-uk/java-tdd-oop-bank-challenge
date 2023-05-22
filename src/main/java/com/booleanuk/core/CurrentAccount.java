package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account{

    public CurrentAccount(Customer customer, double initialBalance) {
        super(-1, 0.25f, BigDecimal.valueOf(initialBalance));
        setCustomer(customer);
    }

    @Override
    public boolean requestOverdraft(double amount) {
        if(!getOverdraftRequest().getStatus().equals(Bank.OverdraftStatus.NONE)) return false;

        setOverdraftRequest(new OverdraftRequest(this, amount,getBalance().doubleValue()));
        return true;
    }
}
