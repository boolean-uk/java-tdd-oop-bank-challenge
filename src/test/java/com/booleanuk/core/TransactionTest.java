package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void testGetTransactionType() {
        Transaction transaction = new Transaction("Deposit", 1000.0);
        assertEquals("Deposit", transaction.getTransactionType());
    }

    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction("Deposit", 1000.0);
        assertEquals(1000.0, transaction.getAmount());
    }

    @Test
    public void testGetDate() {
        Transaction transaction = new Transaction("Deposit", 1000.0);
        assertNotNull(transaction.getDate());
    }

    @Test
    public void testGetCredit() {
        Transaction depositTransaction = new Transaction("Deposit", 1000.0);
        assertEquals("1000.00", depositTransaction.getCredit());

        Transaction withdrawalTransaction = new Transaction("Withdrawal", 500.0);
        assertEquals("", withdrawalTransaction.getCredit());
    }

    @Test
    public void testGetDebit() {
        Transaction withdrawalTransaction = new Transaction("Withdrawal", 500.0);
        assertEquals("500.00", withdrawalTransaction.getDebit());

        Transaction depositTransaction = new Transaction("Deposit", 1000.0);
        assertEquals("", depositTransaction.getDebit());
    }

    @Test
    public void testGetBalance() {
        Transaction transaction = new Transaction("Deposit", 1000.0);
        assertEquals(1000.0, transaction.getBalance());
    }
}

