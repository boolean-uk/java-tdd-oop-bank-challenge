package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void createAccountTest() {
        Account account = new Account(500);
    }

    @Test
    public void getCurrentBalance() {
        Account account = new Account(500);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void depositMoneyTest() {
        Account account = new Account(500);

        account.depositMoney(1000);

        Assertions.assertEquals(1500, account.getBalance());
    }

    @Test
    public void withdrawMoneyTest() {
        Account account = new Account(500);

        account.withdrawMoney(250);

        Assertions.assertEquals(250, account.getBalance());
    }

    @Test
    public void checkBalanceCheckerTest() {
        Account account = new Account(500);

        account.depositMoney(500);

        Assertions.assertEquals(account.getBalanceChecker(), account.getBalance());
    }
}
