package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TestTransaction {
    @Test
    public void testTransactionCreationAndGetters() {
        LocalDateTime now = LocalDateTime.now();
        Transaction transaction = new Transaction(now, 100.0, 500.0, "Credit");

        // Test getters
        Assertions.assertEquals(now, transaction.getData());
        Assertions.assertEquals(100.0, transaction.getAmount());
        Assertions.assertEquals(500.0, transaction.getCurrentBalance());
        Assertions.assertEquals("Credit", transaction.getDebitOrCredit());
    }

    @Test
    public void testTransactionSetters() {
        LocalDateTime now = LocalDateTime.now();
        Transaction transaction = new Transaction(now, 100.0, 500.0, "Credit");

        // Modify transaction data
        LocalDateTime newDate = now.plusDays(1);
        transaction.setData(newDate);
        transaction.setAmount(200.0);
        transaction.setCurrentBalance(700.0);
        transaction.setDebitOrCredit("Debit");

        // Test setters
        Assertions.assertEquals(newDate, transaction.getData());
        Assertions.assertEquals(200.0, transaction.getAmount());
        Assertions.assertEquals(700.0, transaction.getCurrentBalance());
        Assertions.assertEquals("Debit", transaction.getDebitOrCredit());
    }
}
