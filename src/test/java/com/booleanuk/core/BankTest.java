package com.booleanuk.core;

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
        bank = new Bank();
        savingsAccount = new SavingsAccount("1234 5678 8756 4321", 1);
        currentAccount = new CurrentAccount("8765 4321 1234 5678", 2);
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
        SavingsAccount savingsAccount2 = new SavingsAccount("1234 5678 8756 4321", 10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> bank.addAccount(savingsAccount2));
    }

    @Test
    public void testGenerateAccountNumber() {
        Assertions.assertEquals(CHARACTERS_IN_ACCOUNT_NUMBER, Bank.generateAccountNumber().length());
    }

}
