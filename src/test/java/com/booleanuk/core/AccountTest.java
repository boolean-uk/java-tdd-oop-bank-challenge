package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void getRightBalanceTest() {
        Account acc = new Account(AccountType.CURRENT);
        Assertions.assertTrue(acc.deposit(500.0F));
        Assertions.assertEquals(500.0F, acc.getBalance());
    }

    @Test
    public void getWrongBalanceTest() {
        Account acc = new Account(AccountType.CURRENT);
        acc.deposit(500.0F);
        Assertions.assertNotEquals(0F, acc.getBalance());
    }

    @Test
    public void depositNegativeAmountTest() {
        Account acc = new Account(AccountType.CURRENT);
        Assertions.assertFalse(acc.deposit(-500.0F));
    }

    @Test
    public void sufficientWithdrawalTest() {
        Account acc = new Account(AccountType.CURRENT);
        acc.deposit(500.0F);
        Assertions.assertTrue(acc.withdraw(200.0F));
    }

    @Test
    public void insufficientWithdrawalTest() {
        Account acc = new Account(AccountType.CURRENT);
        acc.deposit(500.0F);
        Assertions.assertFalse(acc.withdraw(1000F));
    }

    @Test
    public void getRightAccountTypeTest() {
        Account acc = new Account(AccountType.CURRENT);
        Assertions.assertEquals(AccountType.CURRENT, acc.getAccountType());
    }

    @Test
    public void getWrongAccountTypeTest() {
        Account acc = new Account(AccountType.CURRENT);
        Assertions.assertNotEquals(AccountType.SAVING, acc.getAccountType());
    }
}
