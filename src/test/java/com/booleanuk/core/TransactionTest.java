package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransactionTest {

    @Test
    public void getDateTimeWithoutNano() {
        Transaction transaction = new Transaction(100, 100);
        Assertions.assertEquals(transaction.dateTime.minusNanos(transaction.dateTime.getNano()), transaction.getDateTime());
    }

    @Test
    public void getAmount() {
        Transaction transaction = new Transaction(100, 100);
        Assertions.assertEquals(100, transaction.getAmount());
    }

    @Test
    public void getBalance() {
        Transaction transaction = new Transaction(100, 100);
        Assertions.assertEquals(100, transaction.getBalance());
    }
}