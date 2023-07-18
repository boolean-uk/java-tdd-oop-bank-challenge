package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankManagerTest {
    BankManager bankManager;

    @BeforeEach
    public void initializeTest() {
        bankManager = new BankManager();
    }

    @Test
    public void shouldCreateNewCurrentAccount() {
        // Arrange
        boolean result;
        // Act
        result = bankManager.createAccount(AccountType.CURRENT);
        // Assert
        Assertions.assertTrue(result);
        Assertions.assertNotNull(bankManager.getAccount("CUR0"));
    }

    @Test
    public void shouldCreateNewSavingsAccount() {
        // Arrange
        boolean result;
        // Act
        result = bankManager.createAccount(AccountType.SAVINGS);
        // Assert
        Assertions.assertTrue(result);
        Assertions.assertNotNull(bankManager.getAccount("SAV0"));
    }

    @Test
    public void shouldDeposit() {

        bankManager.createAccount(AccountType.CURRENT);
        Account account = bankManager.getAccount()
    }

//    @Test
//    public void shouldGenerateBankStatements() {
//        bankManager.createAccount(AccountType.CURRENT);
//        bankManager.getAccounts().get("CUR0").printStatement();
//    }
}
