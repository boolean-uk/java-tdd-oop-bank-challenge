package com.booleanuk.core.account;

import com.booleanuk.core.statement.Statements;

public class SavingsBankAccount extends BasicBankAccount {
    public SavingsBankAccount(double balance, Statements statements) {
        super(balance, statements);
    }

    @Override
    public boolean deserveOverdraft(double maxDebt) {
        return false;
    }
}
