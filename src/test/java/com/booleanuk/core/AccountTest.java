package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AccountTest {
    @Test
    public void testDeposit()
    {
        Account account = new Account("Spending");
        account.deposit(10000);
        Assertions.assertEquals(10000, account.getBalance());
        account.deposit(400);
        Assertions.assertEquals(10400, account.getBalance());
        account.deposit(1);
        Assertions.assertEquals(10401, account.getBalance());
    }

    @Test
    public void testWithdraw()
    {
        Account account = new Account("Spending");
        account.deposit(10000);
        Assertions.assertEquals(10000, account.getBalance());
        account.withdraw(400);
        Assertions.assertEquals(9600, account.getBalance());
        account.withdraw(1);
        Assertions.assertEquals(9599, account.getBalance());
    }
}
