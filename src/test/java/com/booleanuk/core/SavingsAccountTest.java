package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    void createShouldSucceed() {
        int accounts = Account.accounts.size();
        Assertions.assertEquals(accounts, Account.accounts.size());
        Account.create("Test Branch");
        Assertions.assertEquals(accounts + 1, Account.accounts.size());
        SavingsAccount.create("Test Branch");
        Assertions.assertEquals(accounts + 2, Account.accounts.size());
    }
}
