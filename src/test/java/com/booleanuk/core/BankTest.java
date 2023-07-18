package com.booleanuk.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankTest {
    private SavingsAccount savingsAccount;
    private CurrentAccount currentAccount;
    private Bank bank;
    private static final int CHARACTERS_IN_ACCOUNT_NUMBER = 19;

    @BeforeEach
    public void setUp() {
        bank = Bank.getInstance();
        String branchCode = "123";
        savingsAccount = new SavingsAccount("1234 5678 8756 4321", 1, branchCode);
        currentAccount = new CurrentAccount("8765 4321 1234 5678", 2, branchCode);
    }

    @AfterEach
    public void tearDown() {
        bank.reset();
    }

    @Test
    public void testAddAccount() {
        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        Assertions.assertEquals(List.of(savingsAccount, currentAccount), bank.getAccounts());
    }

    @Test
    public void testAddSameAccountShouldThrowException() {
        bank.addAccount(savingsAccount);
        SavingsAccount savingsAccount2 = new SavingsAccount("1234 5678 8756 4321", 10, "123");
        Assertions.assertThrows(IllegalArgumentException.class, () -> bank.addAccount(savingsAccount2));
    }

    @Test
    public void testGenerateAccountNumber() {
        String accountNumber = bank.generateAccountNumber();
        System.out.println(accountNumber);
        Assertions.assertEquals(CHARACTERS_IN_ACCOUNT_NUMBER, accountNumber.length());
        Assertions.assertTrue(accountNumber.matches("\\d{4} \\d{4} \\d{4} \\d{4}"));
    }

    @Test
    public void testGetAccountNumbers() {
        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);
        Assertions.assertEquals(List.of("1234 5678 8756 4321", "8765 4321 1234 5678"), bank.getAccountNumbers());
    }

    @Test
    public void testGetAccountNumbersWhenNoAccounts() {
        Assertions.assertEquals(List.of(), bank.getAccountNumbers());
    }

    @Test
    public void testBankShouldBeSingleton() {
        Bank bank2 = Bank.getInstance();
        Assertions.assertEquals(bank, bank2);
    }

    @Test
    public void testAddStatement() {
        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);
        BankStatement statement1 = new BankStatement("1234 5678 8756 4321");
        BankStatement statement2 = new BankStatement("8765 4321 1234 5678");
        bank.addStatement(statement1);
        bank.addStatement(statement2);
        Assertions.assertEquals(List.of(statement1, statement2), bank.getStatements());
    }

}
