package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account{
    public final static BigDecimal overdraftLimit=BigDecimal.valueOf(-400);
    public CurrentAccount(BigDecimal amount,String branchID) {
        super(amount,branchID);
    }
    @Override
    void withdraw(BigDecimal withdraw) {
        var newAmount = amount.subtract(withdraw);
        if (newAmount.compareTo(overdraftLimit) > 0) {
            this.amount = newAmount;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
