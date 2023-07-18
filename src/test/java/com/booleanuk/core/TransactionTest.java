package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionTest {

    @Test
    public void constructorTest() {
        //Given
        String dateString = "2023-07-20";
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);

        //When
        Transaction transaction = new Transaction(date, 1000);

        //Then
        Assertions.assertEquals(date, transaction.date);
        Assertions.assertEquals(1000, transaction.amount);
    }
}
