package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AccountTest {
    @Test
    public void BalanceTest() {
        //added here CurrentAccount, but works for SavingsAccount and plain Account too.
        Account account = new CurrentAccount(123, "abc123");
        Assertions.assertTrue(account.deposit(1000));
        Assertions.assertFalse(account.deposit(-1000));
        Assertions.assertFalse(account.withdraw(3000));
        account.deposit(2000);
        Assertions.assertTrue(account.withdraw(1000));
        Assertions.assertFalse(account.deposit(-1000));
    }

    @Test
    public void BalanceSumTest() {
        //added here CurrentAccount, but works for SavingsAccount and plain Account too.
        Account account = new CurrentAccount(123, "abc123");
        account.deposit(1000);
        account.withdraw(500);
        account.deposit(1000);
        Assertions.assertEquals(1500, account.Balance());
    }

    @Test
    public void TransactionDateTest() {
        Account account = new CurrentAccount(123, "abc123");
        account.deposit(1000);
        Assertions.assertEquals(LocalDateTime.now().getHour(), account.getTransactionHour(0));
        account.deposit(2000);
        account.deposit(2000);
        Assertions.assertEquals(LocalDateTime.now().getHour(), account.getTransactionHour(2));
    }

    @Test
    public void OverdrafTest() {
        Account account = new CurrentAccount(123, "abc123");
        account.Overdraft(true);
        Assertions.assertFalse(account.withdraw(3000));
        Assertions.assertTrue(account.withdraw(1000));
        Assertions.assertEquals(-1000, account.Balance());
    }
}
