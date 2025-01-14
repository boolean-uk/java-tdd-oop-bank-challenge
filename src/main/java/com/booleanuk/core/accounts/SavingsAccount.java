package com.booleanuk.core.accounts;

public class SavingsAccount extends Account{

    private Double interestRate;

    // TODO: Could this constructor be protected?
    //  should not be able to create without a Bank

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
        this.setBranch(Branch.BRANCH_1);
        this.setPossibleToOverdraft(false);
        this.interestRate = 0.12;
    }
}
