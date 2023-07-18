package com.booleanuk.core;

import java.math.BigDecimal;

public enum AccountType {
    CURRENT("Current ",BigDecimal.ZERO,true),
    SAVINGS("Saving Account ",BigDecimal.ZERO, false);

    private String type;



    private BigDecimal balance;

    private boolean enabledForExternalTransactions;

    AccountType(String type, BigDecimal balance, boolean enabledForExternalTransactions){
        this.type = type;
        this.balance = balance;
        this.enabledForExternalTransactions = enabledForExternalTransactions;
    }

    public String getType() {
        return type;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal balance) {
        return this.balance = balance;
    }
}