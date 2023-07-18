package com.booleanuk.core;

import java.math.BigDecimal;

public class OverDraft {

    private Account account;
    private BigDecimal overdraft;


    public OverDraft(Account account, BigDecimal overdraft) {
        this.account = account;
        this.overdraft = overdraft;
    }
}
