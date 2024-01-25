package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void getDateTimeWithoutNano() {
        Transaction transaction = new Transaction(100, 100);
        Assertions.assertEquals(transaction.dateTime.minusNanos(transaction.dateTime.getNano()), transaction.getDateTime());
    }

    @Test
    void getAmount() {
        Transaction transaction = new Transaction(100, 100);
        Assertions.assertEquals(100, transaction.getAmount());
    }

    @Test
    void getBalance() {
        Transaction transaction = new Transaction(100, 100);
        Assertions.assertEquals(100, transaction.getBalance());
    }
}