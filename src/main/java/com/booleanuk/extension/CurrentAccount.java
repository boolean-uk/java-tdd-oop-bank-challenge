package com.booleanuk.extension;

import java.math.BigDecimal;

public class CurrentAccount extends Account {
    private Overdraft overdraft;

    public CurrentAccount(BankBranch bankBranch) {
        super(bankBranch);
    }

    public void requestOverdraft(Overdraft overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    protected boolean canWithdraw(BigDecimal amount) {
        if(getBalance().compareTo(amount) >= 0)
            return true;

        if(overdraft.isPending())
            return false;

        if(!overdraft.isApproved())
            return false;

        return getBalance().add(overdraft.getAmount()).compareTo(amount) >= 0;
    }
}
