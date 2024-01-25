package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testCreatingAccountAndDeposit(){
        Account account = new SavingsAccount(1, "John");
        Assertions.assertTrue(account.deposit(1000));

    }
    @Test
    public void testWithdrawingFromAccountWithInsufficientFunds(){
        Account account = new CurrentAccount(1, "John");
        Assertions.assertFalse(account.withdraw(200));
    }

    @Test
    public void testWithdrawingFromAccountWithSufficientFunds(){
        Account account = new CurrentAccount(1, "John");
        account.deposit(1000);
        Assertions.assertTrue(account.withdraw(200));
    }
}
