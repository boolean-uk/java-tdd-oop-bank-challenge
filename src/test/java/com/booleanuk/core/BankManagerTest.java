package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankManagerTest {
    BankManager bankManager;

    @BeforeEach
    public void initializeTest() {
        bankManager = new BankManager();
        bankManager.createAccount(AccountType.CURRENT);
        bankManager.createAccount(AccountType.SAVINGS);
    }

    @Test
    public void shouldCreateNewCurrentAccount() {
        boolean result = bankManager.createAccount(AccountType.CURRENT);
        Assertions.assertTrue(result);
        Assertions.assertTrue(bankManager.getAccounts().containsKey("CUR2"));
    }

    @Test
    public void shouldCreateNewSavingsAccount() {
        boolean result = bankManager.createAccount(AccountType.SAVINGS);
        Assertions.assertTrue(result);
        Assertions.assertTrue(bankManager.getAccounts().containsKey("SAV2"));
    }
}
