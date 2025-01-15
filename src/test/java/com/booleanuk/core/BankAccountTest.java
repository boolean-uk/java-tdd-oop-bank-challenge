package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BankAccountTest {
    private SavingsAccount savingsAccount;
    private CurrentAccount currentAccount;

    @BeforeEach
    public void setUp() {
        HashMap<Integer, Transaction> savingsTransactions = new HashMap<>() {{
            put(12345, new Transaction(12345, "credit", 200.0, "2025-01-15", 200.0));
            put(54321, new Transaction(54321, "debit", 100.0, "2025-01-15", 100.0));
            put(32145, new Transaction(32145, "credit", 50.0, "2025-01-16", 150.0));
        }};
        HashMap<Integer, Transaction> currentTransactions = new HashMap<>() {{
            put(12345, new Transaction(12345, "credit", 200.0, "2025-01-15", 200.0));
            put(54321, new Transaction(54321, "debit", 100.0, "2025-01-15", 100.0));
            put(32145, new Transaction(32145, "credit", 50.0, "2025-01-16", 150.0));
        }};
        savingsAccount = new SavingsAccount(savingsTransactions, 87654321, 0.0);
        currentAccount = new CurrentAccount(currentTransactions, 54321678, 0.0);
    }

    @Test
    public void testGetBalance() {
        Assertions.assertEquals(150.0, savingsAccount.getBalance());
        Assertions.assertEquals(150.0, currentAccount.getBalance());
    }

    @Test
    public void testDeposit() {
        Assertions.assertEquals("Deposit successfull!", savingsAccount.deposit(30.0));
        Assertions.assertEquals("Deposit successfull!", currentAccount.deposit(40.0));
        Assertions.assertEquals(180.0, savingsAccount.getBalance());
        Assertions.assertEquals(190.0, currentAccount.getBalance());
    }
}
