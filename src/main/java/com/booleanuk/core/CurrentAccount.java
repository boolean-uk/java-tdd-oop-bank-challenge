package com.booleanuk.core;

public class CurrentAccount extends BankAccount {
    public CurrentAccount() {
        super(1);
    }

    public CurrentAccount(int branchNumber) {
        super(branchNumber);
    }
}
