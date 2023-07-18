package com.booleanuk.extensions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CurrentAccountTest {

    CurrentAccount account;
    final static String POUND = "\u00a3";
    @BeforeEach
    void setUp() {
        account = new CurrentAccount();
    }

    @Test
    void depositTest_depositValidAmount(){
        float amount = 100;
        LocalDate date = LocalDate.of(2023, 7, 18);
        String message = account.deposit(amount, date);

        Assertions.assertEquals("100.0" + POUND + " deposited into your account.", message);
        Assertions.assertEquals(100, account.countTheBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(100, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(date, account.getTransactionsHistory().get(0).getDate());
    }

    @Test
    void depositTest_depositValidAmountAndInvalidDate(){
        float amount = 100;
        LocalDate date = LocalDate.of(2023, 7, 18);
        LocalDate date2 = LocalDate.of(2023, 7, 15);
        account.deposit(amount, date);
        String message = account.deposit(amount, date2);

        Assertions.assertEquals("You cannot deposit any money before the last date in transactions history.", message);
        Assertions.assertEquals(100, account.countTheBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(100, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(date, account.getTransactionsHistory().get(0).getDate());
    }

    @Test
    void depositTest_depositInvalidAmount(){
        float amount = -100;
        LocalDate date = LocalDate.of(2023, 7, 18);
        String message = account.deposit(amount, date);

        Assertions.assertEquals("Amount is invalid", message);
        Assertions.assertEquals(0, account.countTheBalance());
        Assertions.assertEquals(0, account.getTransactionsHistory().size());
    }

    @Test
    void withdrawTest_withdrawValidAmountAndValidDate(){
        float amountToDeposit = 100;
        float amountToWithdraw = 50;
        LocalDate depositDate = LocalDate.of(2023, 7, 18);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 18);
        account.deposit(amountToDeposit, depositDate);
        String message = account.withdraw(amountToWithdraw, withdrawDate);

        Assertions.assertEquals("50.0" + POUND + " withdrawn from your account.", message);
        Assertions.assertEquals(50, account.countTheBalance());
        Assertions.assertEquals(2, account.getTransactionsHistory().size());

        Assertions.assertTrue(account.getTransactionsHistory().get(1).getAmount()<0);
        Assertions.assertEquals(amountToWithdraw, Math.abs(account.getTransactionsHistory().get(1).getAmount()));
        Assertions.assertEquals(withdrawDate, account.getTransactionsHistory().get(1).getDate());
    }

    @Test
    void withdrawTest_withdrawValidAmountAndInvalidDate(){
        float amountToDeposit = 100;
        float amountToWithdraw = 50;
        LocalDate depositDate = LocalDate.of(2023, 7, 18);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 15);
        account.deposit(amountToDeposit, depositDate);
        String message = account.withdraw(amountToWithdraw, withdrawDate);

        Assertions.assertEquals("You cannot withdraw any money before the last date in transactions history.", message);
        Assertions.assertEquals(100, account.countTheBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(amountToDeposit, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(depositDate, account.getTransactionsHistory().get(0).getDate());
    }

    @Test
    void withdrawTest_withdrawInvalidAmount(){
        float amountToDeposit = 100;
        float amountToWithdraw = -50;
        LocalDate depositDate = LocalDate.of(2023, 7, 18);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 18);
        account.deposit(amountToDeposit, depositDate);
        String message = account.withdraw(amountToWithdraw, withdrawDate);

        Assertions.assertEquals("Amount is invalid.", message);
        Assertions.assertEquals(100, account.countTheBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(amountToDeposit, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(depositDate, account.getTransactionsHistory().get(0).getDate());
    }

    @Test
    void withdrawTest_withdrawMoreAmountThanIsInTheAccount_IfOverdraftOff(){
        float amountToDeposit = 100;
        float amountToWithdraw = 500;
        LocalDate depositDate = LocalDate.of(2023, 7, 15);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 18);
        account.setOverdraft(false);
        account.deposit(amountToDeposit, depositDate);
        String message = account.withdraw(amountToWithdraw, withdrawDate);

        Assertions.assertEquals("You do not have enough money in your account.", message);
        Assertions.assertEquals(100, account.countTheBalance());
        Assertions.assertEquals(1, account.getTransactionsHistory().size());
        Assertions.assertEquals(amountToDeposit, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(depositDate, account.getTransactionsHistory().get(0).getDate());
    }

    @Test
    void withdrawTest_withdrawMoreAmountThanIsInTheAccount_IfOverdraftOn(){
        float amountToDeposit = 100;
        float amountToWithdraw = 500;
        LocalDate depositDate = LocalDate.of(2023, 7, 15);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 18);
        account.setOverdraft(true);
        account.deposit(amountToDeposit, depositDate);
        String message = account.withdraw(amountToWithdraw, withdrawDate);

        Assertions.assertEquals("Overdraft has been used. Your balance is: -400"+ POUND, message);
        Assertions.assertEquals(-400, account.countTheBalance());
        Assertions.assertEquals(2, account.getTransactionsHistory().size());
        Assertions.assertEquals(amountToDeposit, account.getTransactionsHistory().get(0).getAmount());
        Assertions.assertEquals(depositDate, account.getTransactionsHistory().get(0).getDate());
        Assertions.assertEquals(amountToWithdraw, account.getTransactionsHistory().get(1).getAmount());
        Assertions.assertEquals(withdrawDate, account.getTransactionsHistory().get(1).getDate());
    }

    @Test
    void generateBankStatementTest(){
        float amountToDeposit = 100;
        float amountToDeposit2 = 200;
        float amountToWithdraw = 50;
        LocalDate depositDate = LocalDate.of(2023, 7, 10);
        LocalDate depositDate2 = LocalDate.of(2023, 7, 15);
        LocalDate withdrawDate = LocalDate.of(2023, 7, 18);
        account.deposit(amountToDeposit, depositDate);
        account.deposit(amountToDeposit2, depositDate2);
        account.withdraw(amountToWithdraw, withdrawDate);
        String result = account.generateBankStatement();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        StringBuilder expected = new StringBuilder();
        expected.append(String.format("%-13s || %-10s || %-10s || %-10s\n",  " date", "credit", "debit", "balance"));
        expected.append(String.format(" %-12s || %-10s || %-10.2f || %.2f\n",  withdrawDate.format(formatter), " ", amountToWithdraw, amountToDeposit + amountToDeposit2 - amountToWithdraw));
        expected.append(String.format(" %-12s || %-10.2f || %-10s || %.2f\n",  depositDate2.format(formatter), amountToDeposit2, " ", amountToDeposit + amountToDeposit2));
        expected.append(String.format(" %-12s || %-10.2f || %-10s || %.2f\n",  depositDate.format(formatter), amountToDeposit, " ", amountToDeposit));

        Assertions.assertEquals(expected.toString(), result);
    }

}