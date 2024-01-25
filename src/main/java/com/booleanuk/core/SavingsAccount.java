package com.booleanuk.core;

public class SavingsAccount extends Account {


    public SavingsAccount(int accountNumber, Branches branch) {
        super(accountNumber, branch);
        this.minLimit = 0.00;
    }
}
