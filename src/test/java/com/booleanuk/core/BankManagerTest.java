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
        Account result;
        // Act
        result = bankManager.createAccount(AccountType.CURRENT);
        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(bankManager.getAccount("CUR0"));
    }

    @Test
    public void shouldCreateNewSavingsAccount() {
        // Arrange
        Account result;
        // Act
        result = bankManager.createAccount(AccountType.SAVINGS);
        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(bankManager.getAccount("SAV0"));
    }

    @Test
    public void shouldDeposit() {
        // Arrange
        Account account;
        double amount;
        boolean result;
        // Act;
        account = bankManager.createAccount(AccountType.CURRENT);
        amount = 200.00;
        result = account.deposit(amount);
        // Assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(1200.00, account.getBalance());
    }

    @Test
    public void shouldWithdraw() {
        // Arrange
        Account account;
        double amount;
        boolean result;
        // Act;
        account = bankManager.createAccount(AccountType.CURRENT);
        amount = 200.00;
        result = account.withdraw(amount);
        // Assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(800.00, account.getBalance());
    }
}
