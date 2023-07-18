package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void BalanceTest() {
        //added here CurrentAccount, but works for SavingsAccount and plain Account too.
        Account account = new CurrentAccount(123, "abc123");
        Assertions.assertEquals(true, account.deposit(1000));
        Assertions.assertEquals(false, account.deposit(-1000));
        Assertions.assertEquals(false, account.withdraw(3000));
        account.deposit(2000);
        Assertions.assertEquals(true, account.withdraw(1000));
        Assertions.assertEquals(false, account.deposit(-1000));
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
}
