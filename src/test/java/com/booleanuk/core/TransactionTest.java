package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    @Test
    public void testTransactionProperties() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 7, 18, 11, 5);
        BigDecimal amount = new BigDecimal("1000");
        TransactionType type = TransactionType.DEPOSIT;

        Transaction transaction = new Transaction(dateTime, amount, type);

        assertEquals(dateTime, transaction.getDateTime());
        assertEquals(amount, transaction.getAmount());
        assertEquals(type, transaction.getType());
    }
}
