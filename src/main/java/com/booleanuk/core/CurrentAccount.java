package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account{

    public CurrentAccount(String branch, double initialBalance) throws IllegalArgumentException{

        super(branch, -1, true, 0.25f, BigDecimal.valueOf(initialBalance));
    }
}
