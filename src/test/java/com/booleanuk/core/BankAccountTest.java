package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankAccountTest {

    @Test
    public void constructorTest() {
        new BankAccount();
    }

    @Test
    public void makeTransactionTest_WhenEverythingIsCorrect_ShouldReturnTrue () {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);
        Transaction transaction1 = new Transaction(date, 1000);
        Transaction transaction2 = new Transaction(date, -500);

        //When
        boolean result1 = bankAccount.makeTransaction("main", transaction1);
        boolean result2 = bankAccount.makeTransaction("main", transaction2);

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    public void makeTransactionTest_WhenAccountNameIsInvalid_ShouldReturnFalse () {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);
        Transaction transaction1 = new Transaction(date, 1000);

        //When
        boolean result1 = bankAccount.makeTransaction("mainn", transaction1);

        //Then
        Assertions.assertFalse(result1);
    }

    @Test
    public void showAccountHistoryTest() {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);
        Transaction transaction1 = new Transaction(date, 1000);
        Transaction transaction2 = new Transaction(date, -500);
        bankAccount.makeTransaction("main", transaction1);
        bankAccount.makeTransaction("main", transaction2);

        //When
        String result = bankAccount.showAccountHistory("main");
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("date       || credit  || debit  || balance\n");
        expectedResult.append("2023-07-20 || 1000.0  ||        || 1000.0\n");
        expectedResult.append("2023-07-20 ||         || 500.0  || 500.0");

        //Then
        Assertions.assertEquals(expectedResult.toString(), result);
    }
}
