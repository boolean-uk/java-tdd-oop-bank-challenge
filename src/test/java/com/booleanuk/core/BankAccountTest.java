package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        HashMap<Integer, Transaction> transactions = new HashMap<>() {{
            put(12345, new Transaction(12345, "credit", 200.0, "2025-01-15", 200.0));
            put(54321, new Transaction(54321, "debit", 100.0, "2025-01-15", 100.0));
            put(32145, new Transaction(32145, "credit", 50.0, "2025-01-16", 150.0));
        }};
        bankAccount = new BankAccount(transactions, 12345678, 0.0);
    }

    @Test
    public void testGetBalance() {
        Assertions.assertEquals(150.0, bankAccount.getBalance());
    }
}
