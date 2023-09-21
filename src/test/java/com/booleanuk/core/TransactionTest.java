package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionTest {
    @Test
    void shouldReturnCorrectAmount(){
        Transaction transaction = new Transaction(100.0, true);
        Assertions.assertEquals(100.0, transaction.getAmount());
    }

    @Test
    void shouldBeDeposit(){
        Transaction transaction = new Transaction(100.0, true);
        Assertions.assertTrue(transaction.isDeposit());
    }

    @Test
    void shouldBeWithdrawal(){
        Transaction transaction = new Transaction(100.0, false);
        Assertions.assertFalse(transaction.isDeposit());
    }

    @Test
    void shouldPrintDepositCorrectly(){
        Transaction transaction = new Transaction(1000.0, true);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = today.format(formatter);
        String expected = date + " || " + String.format("%.2f",1000.0) + " ||         || ";
        Assertions.assertEquals(expected, transaction.printData());
    }

    @Test
    void shouldPrintWithdrawalCorrectly(){
        Transaction transaction = new Transaction(1000.0, false);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = today.format(formatter);
        String expected = date + " ||         || " + String.format("%.2f",1000.0) + " || ";
        Assertions.assertEquals(expected, transaction.printData());
    }
}
