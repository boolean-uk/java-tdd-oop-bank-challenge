package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.OVERDRAFT_STATE;

import java.math.BigDecimal;

public class OverdraftRequest {

    private final Account account;
    private OVERDRAFT_STATE state;
    private final BigDecimal amount;

    OverdraftRequest(BigDecimal amount, Account account) {
        if (amount == null || account == null)
            throw new NullPointerException("All fields must be non-null.");
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new ArithmeticException("The amount can't be zero or negative number.");

        this.account = account;
        this.amount = amount;
        this.state = OVERDRAFT_STATE.PENDING;
    }

    public Account getAccount() {
        return account;
    }

    public OVERDRAFT_STATE getState() {
        return state;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setState(OVERDRAFT_STATE state) {
        this.state = state;
    }
}
