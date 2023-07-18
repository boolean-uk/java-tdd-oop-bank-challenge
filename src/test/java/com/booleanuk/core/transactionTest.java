package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class transactionTest {
    private final LocalDateTime date = LocalDateTime.of(2021, 1, 1, 0, 0, 0);

    @Test
    public void assertTransactionIsCreated() {
        Transaction transaction = new Transaction(100, date, TransactionType.CREDIT, 100);
        Assertions.assertEquals(100, transaction.balanceAfter());
        String actualDate = transaction.transactionDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Assertions.assertEquals("01/01/2021", actualDate);
        Assertions.assertEquals(TransactionType.CREDIT, transaction.type());
        Assertions.assertEquals(100, transaction.amount());
    }

    @Test
    public void assertTransactionWithNegativeBalanceThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(-100, date, TransactionType.CREDIT, 100);
        });
    }


    @Test
    public void assertTransactionWithInvalidAmountThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(100, date, TransactionType.CREDIT, -100);
        });
    }

}
