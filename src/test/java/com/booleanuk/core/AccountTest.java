package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}
