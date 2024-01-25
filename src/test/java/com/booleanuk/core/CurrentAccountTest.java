package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    //User story 1
    @Test
    public void assertCurrentAccountWasCreated() {
        int accountId = 123;
        CurrentAccount currentAccount = new CurrentAccount(accountId, new BankStatementGenerator());
        Assertions.assertEquals(accountId, currentAccount.getAccountId());
        Assertions.assertEquals(0.0, currentAccount.getBalance());
    }
}
