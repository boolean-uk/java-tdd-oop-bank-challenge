package com.booleanuk.core.accounts;

public class CurrentAccount extends Account{

    // TODO: Could this constructor be protected?
    //  should not be able to create without a Bank
    
    public CurrentAccount(String accountNumber) {
        super(accountNumber);
        this.setBranch(Branch.BRANCH_1);
        this.setPossibleToOverdraft(true);
    }
}
