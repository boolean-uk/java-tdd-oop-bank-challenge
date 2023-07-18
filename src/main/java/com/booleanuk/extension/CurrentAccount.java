package com.booleanuk.extension;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(double initialBalance) {
        super(initialBalance);
    }
    public CurrentAccount(double initialBalance, Branch branch) {
        super(initialBalance, branch);
    }
}
