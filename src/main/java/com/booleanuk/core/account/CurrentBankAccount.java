package com.booleanuk.core.account;

import com.booleanuk.core.statement.Statements;

public class CurrentBankAccount extends BasicBankAccount {
    public CurrentBankAccount(double balance, Statements statements) {
        super(balance, statements);
    }
}
