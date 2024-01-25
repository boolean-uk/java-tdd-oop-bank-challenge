package com.booleanuk.core;

public class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, Branches branch) {
        super(accountNumber, branch);
        this.minLimit = -100.00;
    }
}
