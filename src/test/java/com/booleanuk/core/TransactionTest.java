package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionTest {
    private static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    @Test
    public void testTransactionWithdraw(){
        Transaction transaction = new Transaction(100, "WITHDRAW");

        Assertions.assertEquals(100, transaction.getAmount());
        Assertions.assertEquals("WITHDRAW", transaction.getType());

        String date = LocalDateTime.now().format(timeFormat);
        Assertions.assertEquals(date, transaction.getDate());
    }

    @Test
    public void testTransactionDeposit(){
        Transaction transaction = new Transaction(100, "DEPOSIT");

        Assertions.assertEquals(100, transaction.getAmount());
        Assertions.assertEquals("DEPOSIT", transaction.getType());

        String date = LocalDateTime.now().format(timeFormat);
        Assertions.assertEquals(date, transaction.getDate());
    }
}
