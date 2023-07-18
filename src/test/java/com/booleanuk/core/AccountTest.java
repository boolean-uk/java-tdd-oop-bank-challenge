package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AccountTest {
    private Account account;
    @Test
    public void testGenerateInfo() {
        account = new Account(1, "Savings", 0);
        LocalDateTime dateTime1 = LocalDateTime.of(2012, 1, 10, 0, 0);
        account.generateInfo(1000, dateTime1, "debit");

        LocalDateTime dateTime2 = LocalDateTime.of(2012, 1, 13, 0, 0);
        account.generateInfo(2000, dateTime2, "debit");

        LocalDateTime dateTime3 = LocalDateTime.of(2012, 1, 14, 0, 0);
        account.generateInfo(500, dateTime3, "credit");

        Assertions.assertEquals(3, account.getInfo().size());
        Assertions.assertEquals(2500, account.getBalance());
    }

    @Test
    public void testIfGenerateInfoContains(){
        account = new Account(1, "Savings", 0);
        LocalDateTime dateTime1 = LocalDateTime.of(2012, 1, 10, 0, 0);
        account.generateInfo(1000, dateTime1, "debit");

        LocalDateTime dateTime2 = LocalDateTime.of(2012, 1, 13, 0, 0);
        account.generateInfo(2000, dateTime2, "debit");

        LocalDateTime dateTime3 = LocalDateTime.of(2012, 1, 14, 0, 0);
        account.generateInfo(500, dateTime3, "credit");
        Info firstTransaction = account.getInfo().get(0);
        Assertions.assertEquals(dateTime1, firstTransaction.getDateTime());
        Assertions.assertEquals(1000, firstTransaction.getAmount());
        Assertions.assertEquals(1000, firstTransaction.getBalance());

        Info secondTransaction = account.getInfo().get(1);
        Assertions.assertEquals(dateTime2, secondTransaction.getDateTime());
        Assertions.assertEquals(2000, secondTransaction.getAmount());
        Assertions.assertEquals(3000, secondTransaction.getBalance());

        Info thirdTransaction = account.getInfo().get(2);
        Assertions.assertEquals(dateTime3, thirdTransaction.getDateTime());
        Assertions.assertEquals(500, thirdTransaction.getAmount());
        Assertions.assertEquals(2500, thirdTransaction.getBalance());
    }

    @Test
    public void testIfCalculateBalanceWorks(){
        account = new Account(1, "Savings");
        Assertions.assertEquals(0, account.calculateBalance());

        LocalDateTime dateTime1 = LocalDateTime.of(2023, 7, 15, 10, 30);
        account.addDepositWithoutCalc(1000, dateTime1);
        Assertions.assertEquals(1000, account.calculateBalance());

        LocalDateTime dateTime2 = LocalDateTime.of(2023, 7, 16, 11, 15);
        account.addDepositWithoutCalc(500, dateTime2);
        Assertions.assertEquals(1500, account.calculateBalance());
    }

    @Test
    public void testIfCalculateBalanceWorks2(){
        account = new Account(1, "Savings");
        Assertions.assertEquals(0, account.calculateBalance());

        LocalDateTime dateTime1 = LocalDateTime.of(2023, 7, 15, 10, 30);
        account.addDepositWithoutCalc(2000, dateTime1);

        LocalDateTime dateTime2 = LocalDateTime.of(2023, 7, 16, 11, 15);
        account.addWithdrawalWithoutCalc(500, dateTime2);
        Assertions.assertEquals(1500, account.calculateBalance());

        LocalDateTime dateTime3 = LocalDateTime.of(2023, 7, 17, 14, 45);
        account.addWithdrawalWithoutCalc(1000, dateTime3);
        Assertions.assertEquals(500, account.calculateBalance());
    }


}
