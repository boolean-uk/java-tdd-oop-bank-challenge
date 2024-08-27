package com.booleanuk.core.accounts;

public class CurrentAccount extends Account{

    public CurrentAccount() {
        this.setBranch(Branch.BRANCH_1);
        this.setPossibleToOverdraft(true);
    }
}
