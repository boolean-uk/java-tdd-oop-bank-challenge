package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account{

    public CurrentAccount(double initialBalance) throws IllegalArgumentException{

        super(-1, true, 0.25f, BigDecimal.valueOf(initialBalance));
    }
}
