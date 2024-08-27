package com.booleanuk.core;

public class CurrentAccount extends Account{

    public CurrentAccount(float firstDeposit) {
        super(firstDeposit);
    }

    public CurrentAccount(float firstDeposit, String branch) {
        super(firstDeposit, branch);
    }
}
