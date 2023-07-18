package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankAccountTest {

    @Test
    public void constructorTest() {
        new BankAccount();
    }

    @Test
    public void depositTest_WhenEverythingIsCorrect_ShouldReturnTrue () {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);

        //When
        boolean result1 = bankAccount.deposit("main", 1000, date);
        boolean result2 = bankAccount.deposit("main", 2000, date);

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    public void depositTest_WhenAccountNameIsInvalid_ShouldReturnFalse () {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);

        //When
        boolean result1 = bankAccount.deposit("mainn", 1000, date);

        //Then
        Assertions.assertFalse(result1);
    }

    @Test
    public void depositTest_WhenAmountIsInvalid_ShouldReturnFalse () {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);

        //When
        boolean result1 = bankAccount.deposit("main", -1000, date);

        //Then
        Assertions.assertFalse(result1);
    }

    @Test
    public void withdrawTest_WhenNoMoneyToWithdraw_ShouldReturnFalse () {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);

        //When
        boolean result1 = bankAccount.withdraw("main", 1000, date);
        boolean result2 = bankAccount.withdraw("main", 2000, date);

        //Then
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);
    }

    @Test
    public void withdrawTest_WhenEverythingIsOk_ShouldReturnTrue () {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);
        bankAccount.deposit("main", 1000, date);
        bankAccount.deposit("main", 2000, date);

        //When
        boolean result1 = bankAccount.withdraw("main", 1000, date);
        boolean result2 = bankAccount.withdraw("main", 2000, date);

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }


    @Test
    public void withdrawTest_WhenAccountNameIsInvalid_ShouldReturnFalse () {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);

        //When
        boolean result1 = bankAccount.withdraw("mainn", 1000, date);

        //Then
        Assertions.assertFalse(result1);
    }

    @Test
    public void withdrawTest_WhenAmountIsInvalid_ShouldReturnFalse () {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);

        //When
        boolean result1 = bankAccount.withdraw("main", -1000, date);

        //Then
        Assertions.assertFalse(result1);
    }

    @Test
    public void showAccountHistoryTest() {
        //Given
        BankAccount bankAccount = new BankAccount();

        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate date1 = LocalDate.parse("2023-07-21", DateTimeFormatter.ISO_LOCAL_DATE);
        bankAccount.deposit("main", 1000, date);
        bankAccount.withdraw("main", 500, date);
        bankAccount.deposit("main", 1000, date1);

        //When
        String result = bankAccount.showAccountHistory("main");
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("date       || credit  || debit  || balance\n");
        expectedResult.append("2023-07-20 || 1000.0  ||        || 1000.0\n");
        expectedResult.append("2023-07-20 ||         || 500.0  || 500.0\n");
        expectedResult.append("2023-07-21 || 1000.0  ||        || 1500.0");

        //Then
        Assertions.assertEquals(expectedResult.toString(), result);
    }

    @Test
    public void overDraftRequestTest() {
        //Given
        BankAccount bankAccount = new BankAccount();
        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);

        //When
        boolean result1 = bankAccount.requestOverDraft(1000);

        //Then
        Assertions.assertTrue(result1);
    }

    @Test
    public void overDraftApproveTest() {
        //Given
        BankAccount bankAccount = new BankAccount();
        LocalDate date = LocalDate.parse("2023-07-20", DateTimeFormatter.ISO_LOCAL_DATE);

        //When
        boolean result1 = bankAccount.requestOverDraft(1000);
        boolean result2 = bankAccount.approveOverDraftAmount(1000);
        boolean result3 = bankAccount.withdraw("main", 1000, date);
        boolean result4 = bankAccount.withdraw("main", 100, date);

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertTrue(result3);
        Assertions.assertFalse(result4);
    }
}
