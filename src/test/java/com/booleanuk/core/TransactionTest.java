package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionTest {

    @Test
    public void createTransaction() {
        Transaction transaction = new Transaction(
                1000,
                true
        );

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "uuuu/MM/dd"
                );

        assertEquals(
                dateTime.format(formatter),
                transaction.getDate().format(formatter)
        );
        assertEquals(
                1000,
                transaction.getAmount()
        );
        assertTrue(transaction.isDeposit());
    }
}
