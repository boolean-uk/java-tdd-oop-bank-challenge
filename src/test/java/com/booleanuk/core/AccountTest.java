package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class AccountTest {

    Account account = new Account();

    @Test
    public void depositValidAmount() {
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertTrue(account.deposit(15));
        Assertions.assertEquals(15, account.getBalance());
    }

    @Test
    public void depositInvalidAmount() {
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertFalse(account.deposit(-15));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void withdrawValidAmount() {
        account.deposit(30);
        Assertions.assertTrue(account.withdraw(20));
        Assertions.assertEquals(10, account.getBalance());
    }

    @Test
    public void withdrawMoreThanAccountHas() {
        account.deposit(30);
        Assertions.assertFalse(account.withdraw(40));
        Assertions.assertEquals(30, account.getBalance());
    }

    @Test
    public void withdrawNegativeAmount() {
        Assertions.assertFalse(account.withdraw(-40));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void maintainingCorrectBalanceTest() {
        double a = 23.4322;
        double b = 343.32342;
        double c = 44.432;
        double d = 432.002001;
        double e = 22.119232;

        account.deposit(a);
        account.deposit(b);
        account.deposit(b);
        account.deposit(b);
        account.withdraw(c);
        account.deposit(d);
        account.withdraw(e);

        double ans = a+b*3-c+d-e;

        Assertions.assertEquals(ans, account.getBalance());
    }

    @Test
    public void getEmptyStatementsTest() {
        Assertions.assertEquals(new ArrayList<>(), account.getStatements());
    }

    @Test
    public void getStatementsOnePresentTest() {
        account.deposit(23.231);
        Statement statement = new Statement(new Date(), 23.231, 23.231);
        ArrayList<Statement> expected = new ArrayList<>(Arrays.asList(statement));
        Assertions.assertEquals(expected, account.getStatements());
    }

}
