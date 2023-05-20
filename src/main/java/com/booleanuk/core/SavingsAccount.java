package com.booleanuk.core;

import java.math.BigDecimal;

public class SavingsAccount extends Account{
    public SavingsAccount(String branch, double initialBalance) {
        super(branch, 10, 2.0f, BigDecimal.valueOf(initialBalance));
        setOverdraftStatus(Bank.OverdraftStatus.NON_APPLICABLE);
    }

}
