package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {

    private Bank bank;
    private Account nonExistingAccount;
    @BeforeEach
    void setUp() {
        bank = new Bank();
        nonExistingAccount = new CurrentAccount("XXX", "YYY");
    }

    @Test
    void shouldCreateCurrentAccountSuccessfully() {
        boolean accountCreated = bank.createAccount("Kinga", "Hernet");

        Assertions.assertTrue(accountCreated, "Current account creation should be successful");
        Assertions.assertEquals("Kinga", bank.getAccounts().get(0).getFirstname(), "First name should match with the input");
        Assertions.assertEquals("Hernet", bank.getAccounts().get(0).getLastname(), "Last name should match with the input");
        Assertions.assertEquals(CurrentAccount.class, bank.getAccounts().get(0).getClass(), "The created account should be of CurrentAccount class");
    }

    @Test
    void shouldNotCreateDuplicateCurrentAccount() {
        bank.createAccount("Kinga", "Hernet");

        boolean accountCreated = bank.createAccount("Kinga", "Hernet");

        Assertions.assertFalse(accountCreated, "Current account creation should fail if an account with the same name already exists");
    }

    @Test
    void shouldCreateSavingsAccountSuccessfully() {
        boolean accountCreated = bank.createAccount("Kinga", "Hernet", "Savings");

        Assertions.assertTrue(accountCreated, "Savings account creation should be successful");
        Assertions.assertEquals(SavingAccount.class, bank.getAccounts().get(0).getClass(), "The created account should be of SavingAccount class");
    }

    @Test
    void shouldNotCreateDuplicateSavingsAccount() {
        bank.createAccount("Kinga", "Hernet", "Savings");

        boolean accountCreated = bank.createAccount("Kinga", "Hernet", "Savings");

        Assertions.assertFalse(accountCreated, "Savings account creation should fail if an account with the same name already exists");
    }

    @Test
    void printStatementShouldFailForNonExistingAccount() {
        boolean printResult = bank.printStatement(nonExistingAccount);

        Assertions.assertFalse(printResult, "Print statement should fail for non-existing account");
    }

    @Test
    void printStatementShouldSucceedForExistingAccountWithTransactions() {
        // Arrange
        bank.createAccount("Kinga", "Hernet");
        Account nick = bank.getAccounts().get(0);
        nick.deposit(1500.5);
        nick.withdraw(500.5);
        nick.deposit(200.0);

        // Act
        boolean printResult = bank.printStatement(nick);

        // Assert
        Assertions.assertTrue(printResult, "Print statement should succeed for existing account with transactions");
    }

    @Test
    void printStatementShouldFailForExistingAccountWithoutTransactions() {
        // Arrange
        bank.createAccount("Kinga", "Hernet");
        Account nick = bank.getAccounts().get(0);

        // Act
        boolean printResult = bank.printStatement(nick);

        // Assert
        Assertions.assertFalse(printResult, "Print statement should fail for existing account without transactions");
    }
}