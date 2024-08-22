package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TransactionTest {

    @Test
    public void testCreateTransaction() {
        Transaction transaction = new Transaction(500);
        assertEquals(500, transaction.getAmount());
        assertEquals(new Date(), transaction.getDate());
    }
}
