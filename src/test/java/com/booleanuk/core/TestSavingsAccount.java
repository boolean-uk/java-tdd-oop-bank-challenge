package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSavingsAccount {
    @Test
    public void testPrintTransactions(){
        Account account = new SavingsAccount();
        account.deposit(1600);
        account.withdraw(150);
        account.withdraw(300);
        account.withdraw(240);
        account.deposit(1000);
        account.printTransactions();
    }

    @Test
    public void testWithdrawAndDeposit(){
        Account account = new SavingsAccount();

        Assertions.assertTrue(account.deposit(500));
        Assertions.assertTrue(account.deposit(500));
        Assertions.assertTrue(account.withdraw(300));
        Assertions.assertFalse(account.withdraw(1000));
        Assertions.assertFalse(account.deposit(-500));
        Assertions.assertFalse(account.withdraw((-100)));
    }
}
