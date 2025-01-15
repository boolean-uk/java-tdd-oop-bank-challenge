package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccountTest {
    private ArrayList<Transaction> listOfTransactions = new ArrayList<>(){{
        LocalDateTime dateTime1 = LocalDateTime.of(2024, 9, 7, 13, 24, 10);
        Transaction transaction1 = new Transaction(dateTime1, 200D, "Deposit", 200D);
        add(transaction1);

        LocalDateTime dateTime2 = LocalDateTime.of(2024, 11, 5, 10, 30, 8);
        Transaction transaction2 = new Transaction(dateTime2, 700D, "Deposit", 900D);
        add(transaction2);

        LocalDateTime dateTime3 = LocalDateTime.of(2025, 1, 13, 13, 58, 10);
        Transaction transaction3 = new Transaction(dateTime3, 500D, "Withdraw", 400D);
        add(transaction3);
    }};

    @Test
    public void balanceIncreasesWhenDepositingValidAmount(){
        BankAccount account = new CurrentAccount(1, listOfTransactions);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusDays(4);

        Assertions.assertEquals(600D, account.makeDeposit(200D, dateTime));
    }

    @Test
    public void balanceStaysTheSameWhenDepositingNonValidAmount(){
        BankAccount account = new CurrentAccount(1, listOfTransactions);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusDays(4);

        Assertions.assertEquals(400D, account.makeDeposit(-200D, dateTime));
    }

    @Test
    public void balanceDecreasesWhenWithdrawingValidAmount(){
        BankAccount account = new CurrentAccount(1, listOfTransactions);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusDays(4);

        Assertions.assertEquals(300D, account.makeWithDraw(100D, dateTime));
    }

    @Test
    public void balanceStaysTheSameWhenWithdrawingNonValidAmount(){
        BankAccount account = new CurrentAccount(1, listOfTransactions);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusDays(4);

        Assertions.assertEquals(400D, account.makeWithDraw(-100D, dateTime));
    }




    @Test
    public void correctBankStatementsAreOutputed(){
        BankAccount account = new CurrentAccount(1, listOfTransactions);
        String correctBankStatement =
                                "Date                || Credit   || Debit  || Balance\n" +
                                "2025-01-13T13:58:10 ||        || 500.0    || 400.0\n" +
                                "2024-11-05T10:30:08 || 700.0    ||        || 900.0\n" +
                                "2024-09-07T13:24:10 || 200.0    ||        || 200.0\n";

        Assertions.assertEquals(correctBankStatement, account.generateBankStatements());
    }
}
