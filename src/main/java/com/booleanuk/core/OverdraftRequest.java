package com.booleanuk.core;

import com.booleanuk.core.enums.OVERDRAFT_STATE;

import java.math.BigDecimal;

public class OverdraftRequest {
    private final Account account;
    private OVERDRAFT_STATE requestState;
    private final BigDecimal amount;


    public OverdraftRequest(Account account, BigDecimal amount) {
        this.account = account;
        this.requestState = OVERDRAFT_STATE.PENDING;
        this.amount = amount;
    }

    public void setRequestState(OVERDRAFT_STATE state){
        this.requestState = state;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public OVERDRAFT_STATE getRequestState(){
        return requestState;
    }
}
