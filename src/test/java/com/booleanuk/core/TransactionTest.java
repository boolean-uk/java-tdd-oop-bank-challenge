package com.booleanuk.core;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testTransaction() {
        Transaction transaction = new Transaction(null, null, 0);
        Assertions.assertNotNull(transaction);

        transaction.setTransactionAmount(1000);
        Assertions.assertEquals(1000, transaction.getTransactionAmount());

        transaction.setTransactionType("Deposit");
        Assertions.assertEquals("Deposit", transaction.getTransactionType());

        transaction.setTransactionDate(new Date());
        Assertions.assertNotNull(transaction.getTransactionDate());

    }
}
