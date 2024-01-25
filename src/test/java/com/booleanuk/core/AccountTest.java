package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class AccountTest {

    //User story 3
    @Test
    public void generatedBankStatementShouldHaveAllTransactions() {
        Account account = new Account(123);
        account.deposit(100);
        account.withdraw(50);
        String actualBankStatement = account.getBankStatement();
    }
}
