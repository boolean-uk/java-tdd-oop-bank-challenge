package com.booleanuk.extension;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime time;
    private float amount;
    private float balanceAfter;
    private boolean isDeposit;

    public Transaction(float amount, float balanceAfter, boolean isDeposit) {
        this.time = LocalDateTime.now();
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.isDeposit = isDeposit;
    }

    LocalDateTime getTime() {
        return time;
    }

    float getAmount() {
        return amount;
    }

    float getBalanceAfter() {
        return balanceAfter;
    }

    boolean getIsDeposit() {
        return isDeposit;
    }
}
