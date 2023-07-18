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
        result = bankManager.createAccount(AccountType.CURRENT, BankBranch.WARSAW_BANK);
        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(bankManager.getAccount("CUR0"));
    }

    @Test
    public void shouldCreateNewSavingsAccount() {
        // Arrange
        Account result;
        // Act
        result = bankManager.createAccount(AccountType.SAVINGS, BankBranch.WARSAW_BANK);
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
        account = bankManager.createAccount(AccountType.CURRENT, BankBranch.WARSAW_BANK);
        amount = 200.00;
        result = account.deposit(amount);
        // Assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(190.00, account.getBalance());
    }

    @Test
    public void shouldWithdraw() {
        // Arrange
        Account account;
        double amount;
        boolean result;
        // Act;
        account = bankManager.createAccount(AccountType.CURRENT, BankBranch.WARSAW_BANK);
        amount = 200.00;
        result = account.withdraw(amount);
        // Assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(-190.00, account.getBalance());
    }

    @Test
    public void shouldPrintStatement() {
        // Arrange
        Account account;
        // Act;
        account = bankManager.createAccount(AccountType.CURRENT, BankBranch.WARSAW_BANK);
        account.withdraw(521);
        account.withdraw(133);
        account.deposit(1000);
        // Assert (should be done manually by inspecting console result)
        account.printStatement();
    }
}
