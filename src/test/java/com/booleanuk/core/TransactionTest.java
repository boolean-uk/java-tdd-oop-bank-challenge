package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testTransactionConstructor() {
        int ID = 12345;
        String type = "credit";
        double amount = 50.0;
        String date = "2025-01-15";
        double balanceAfter = 50.0;
        Transaction transaction = new Transaction(ID, type, amount, date, balanceAfter);

        Assertions.assertEquals(12345, transaction.getID());
        Assertions.assertEquals("credit", transaction,getType());
        Assertions.assertEquals(50.0, transaction.getAmount());
        Assertions.assertEquals("2025-01-15", transaction.getDate());
        Assertions.assertEquals(50.0, transaction.getBalanceAfter());
    }

}
