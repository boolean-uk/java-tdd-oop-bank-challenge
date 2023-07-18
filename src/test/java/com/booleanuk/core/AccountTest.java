package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AccountTest {

    Account account;
    String pound = "\u00a3";
    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void depositTest_depositValidAmount(){
        double amount = 100;
        LocalDate date = LocalDate.of(2023, 7, 18);
        String message = account.deposit(amount, date);

        Assertions.assertEquals("100" + pound + "deposited into your account.", message);
        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(100, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(date, account.getTransactionsHistory().get(0).getDate());
    }

    @Test
    void depositTest_depositValidAmountAndInvalidDate(){
        double amount = 100;
        LocalDate date = LocalDate.of(2023, 7, 18);
        LocalDate date2 = LocalDate.of(2023, 7, 15);
        account.deposit(amount, date);
        String message = account.deposit(amount, date2);

        Assertions.assertEquals("You cannot deposit any money before the date of the first transaction.", message);
        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(100, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(date, account.getTransactionsHistory().get(0).getDate());
    }

    @Test
    void depositTest_depositInvalidAmount(){
        double amount = -100;
        LocalDate date = LocalDate.of(2023, 7, 18);
        String message = account.deposit(amount, date);

        Assertions.assertEquals("Amount is invalid", message);
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(0, account.getTransactionsHistory().size());
    }

    @Test
    void withdrawTest_withdrawValidAmountAndValidDate(){
        double amountToDeposit = 100;
        double amountToWithdraw = 50;
        LocalDate depositDate = LocalDate.of(2023, 7, 18);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 18);
        account.deposit(amountToDeposit, depositDate);
        String message = account.withdraw(amountToWithdraw, withdrawDate);

        Assertions.assertEquals("100" + pound + "withdrawn from your account.", message);
        Assertions.assertEquals(50, account.getBalance());
        Assertions.assertEquals(2, account.getTransactionsHistory().size());

        Assertions.assertTrue(account.getTransactionsHistory().get(1).getAmount()<0);
        Assertions.assertEquals(amountToWithdraw, Math.abs(account.getTransactionsHistory().get(1).getAmount()));
        Assertions.assertEquals(withdrawDate, account.getTransactionsHistory().get(1).getDate());
    }

    @Test
    void withdrawTest_withdrawValidAmountAndInvalidDate(){
        double amountToDeposit = 100;
        double amountToWithdraw = 50;
        LocalDate depositDate = LocalDate.of(2023, 7, 18);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 15);
        account.deposit(amountToDeposit, depositDate);
        String message = account.withdraw(amountToWithdraw, withdrawDate);

        Assertions.assertEquals("You cannot withdraw any money before the date of the first transaction.", message);
        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(amountToDeposit, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(depositDate, account.getTransactionsHistory().get(0).getDate());
    }

    @Test
    void withdrawTest_withdrawInvalidAmount(){
        double amountToDeposit = 100;
        double amountToWithdraw = -50;
        LocalDate depositDate = LocalDate.of(2023, 7, 18);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 18);
        account.deposit(amountToDeposit, depositDate);
        String message = account.withdraw(amountToWithdraw, withdrawDate);

        Assertions.assertEquals("Amount is invalid.", message);
        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(amountToDeposit, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(depositDate, account.getTransactionsHistory().get(0).getDate());
    }

    @Test
    void withdrawTest_withdrawMoreAmountThanIsInTheAccount(){
        double amountToDeposit = 100;
        double amountToWithdraw = 500;
        LocalDate depositDate = LocalDate.of(2023, 7, 15);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 18);
        account.deposit(amountToDeposit, depositDate);
        String message = account.withdraw(amountToWithdraw, withdrawDate);

        Assertions.assertEquals("You do not have enough money in your account.", message);
        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(amountToDeposit, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(depositDate, account.getTransactionsHistory().get(0).getDate());
    }

}
