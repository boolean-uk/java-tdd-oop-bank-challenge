package com.booleanuk.core;

public class CurrentAccount extends Account{
    public CurrentAccount(int accountId, BankStatementGenerator bankStatementGenerator) {
        super(accountId, bankStatementGenerator, Branch.PERSONAL);
    }
}
