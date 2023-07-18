package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    public void balanceGetterTest() {
        BankAccount account1 = new BankAccount(0.0);
        Assertions.assertEquals(0.0, account1.getBalance());
        BankAccount account2 = new BankAccount(200521.37);
        Assertions.assertEquals(200521.37, account2.getBalance());
    }
    @Test
    public void withdrawTest() {
        BankAccount account = new BankAccount(1000.0);
        Assertions.assertTrue(account.withdraw(200.62));
        Assertions.assertEquals(1000.0 - 200.62, account.getBalance());
        Assertions.assertFalse(account.withdraw(1000.0));
        Assertions.assertEquals(1000.0 - 200.62, account.getBalance());
    }
    @Test
    public void depositTest() {
        BankAccount account = new BankAccount(1000.0);
        account.deposit(200.62);
        Assertions.assertEquals(1000.0 + 200.62, account.getBalance());
        account.deposit(99.38);
        Assertions.assertEquals(1300.0, account.getBalance());
    }
}
