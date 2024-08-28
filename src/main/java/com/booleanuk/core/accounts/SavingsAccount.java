package com.booleanuk.core.accounts;

public class SavingsAccount extends Account{

    private Double interestRate;

    public SavingsAccount() {
        this.setBranch(Branch.BRANCH_1);
        this.setPossibleToOverdraft(false);
        this.interestRate = 0.12;
    }
}
