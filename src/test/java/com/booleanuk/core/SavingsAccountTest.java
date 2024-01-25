package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    //User story 2
    @Test
    public void assertSavingsAccountWasCreated() {
        int accountId = 123;
        SavingsAccount savingsAccount = new SavingsAccount(accountId, new BankStatementGenerator());
        Assertions.assertEquals(accountId, savingsAccount.getAccountId());
        Assertions.assertEquals(0.0, savingsAccount.getBalance());
    }
}
