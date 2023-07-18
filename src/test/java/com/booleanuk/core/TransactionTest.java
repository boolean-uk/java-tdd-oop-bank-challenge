package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionTest {

    Transaction transaction;

    @BeforeEach
    void setUp() {
        LocalDate date = LocalDate.of(2012, 1,10);
        transaction = new Transaction(BigDecimal.valueOf(1000.00), date);
    }

    @Test
    void shouldReturnDate() {
        Assertions.assertEquals(2012, transaction.date().getYear());
        Assertions.assertEquals(1, transaction.date().getMonthValue());
        Assertions.assertEquals(10, transaction.date().getDayOfMonth());
    }

    @Test
    void shouldReturnAmount() {
        Assertions.assertEquals(BigDecimal.valueOf(1000.00), transaction.amount());
    }
}
