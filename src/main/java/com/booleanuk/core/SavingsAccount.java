package com.booleanuk.core;

import java.math.BigDecimal;

public class SavingsAccount extends Account{
    public SavingsAccount(double initialBalance) {
        super(10, 2.0f, BigDecimal.valueOf(initialBalance));
        setOverdraftStatus(Bank.OverdraftStatus.NON_APPLICABLE);
    }

}
