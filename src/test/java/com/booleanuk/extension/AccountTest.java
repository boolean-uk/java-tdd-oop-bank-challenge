package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void testDeposit()
    {
        Bank bank = new Bank();
        Account account = new Account("Spending", bank);
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
        Bank bank = new Bank();
        Account account = new Account("Spending", bank);
        account.deposit(10000);
        Assertions.assertEquals(10000, account.getBalance());
        account.withdraw(400);
        Assertions.assertEquals(9600, account.getBalance());
        account.withdraw(1);
        Assertions.assertEquals(9599, account.getBalance());
    }
}
