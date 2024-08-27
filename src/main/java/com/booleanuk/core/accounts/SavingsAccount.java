package com.booleanuk.core.accounts;

public class SavingsAccount extends Account{

    public SavingsAccount() {
        this.setBranch(Branch.BRANCH_1);
        this.setPossibleToOverdraft(false);
    }
}
