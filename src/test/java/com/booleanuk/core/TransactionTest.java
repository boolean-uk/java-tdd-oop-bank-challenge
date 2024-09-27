package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionTest {
    @Test
    public void createTransaction_withValidData(){
        LocalDate date = LocalDate.of(2023, 7, 18);
        float amount = 12.5f;
        Transaction transaction = new Transaction(date, amount);

        Assertions.assertEquals(date, transaction.getDate());
        Assertions.assertEquals(amount, transaction.getAmount());
    }
}
