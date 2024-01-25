package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    public void testTransactionConstructor() {
        Transaction transaction = new Transaction(new Date(), 100, 1000);
        Assertions.assertEquals(new Date(), transaction.getDate());
        Assertions.assertEquals(100, transaction.getAmount());
        Assertions.assertEquals(1000, transaction.getBalance());
    }

}