package com.booleanuk.core;

import java.math.BigDecimal;

public class OverDraft {

    private Account account;
    private BigDecimal overdraft;


    public OverDraft(Account account, BigDecimal overdraft) {
        this.account = account;
        this.overdraft = overdraft;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }
}
