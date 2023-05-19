package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    void SavingsAccountTest() {
        Assertions.assertEquals(0, Account.accounts.size());
        Account.create("Test Branch");
        Assertions.assertEquals(1, Account.accounts.size());
        SavingsAccount.create("Test Branch");
        Assertions.assertEquals(2, Account.accounts.size());
    }
}
