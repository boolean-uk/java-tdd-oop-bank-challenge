package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account{

    public CurrentAccount(double initialBalance) throws IllegalArgumentException{

        super(-1, 0.25f, BigDecimal.valueOf(initialBalance));

    }

    @Override
    public boolean requestOverdraft(double amount) {
        if(!getOverdraftRequest().getStatus().equals(Bank.OverdraftStatus.NONE)) return false;

        setOverdraftRequest(new OverdraftRequest(this, amount,getBalance().doubleValue()));
        return true;
    }
}
