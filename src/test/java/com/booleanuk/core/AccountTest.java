package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AccountTest {
    private Account account;
    private User user;

    @BeforeEach
    void setUp(){
        user = new User(286, "Thomas", "Oslo");
        account = new Account(user);
    }

    @Test
    public void testSetUpAccount(){
        account.setBalance(2000);
        Assertions.assertEquals(2000, account.getBalance());
        Assertions.assertEquals(0, account.getOverdraft());
    }

    @Test
    public void testWithdraw(){
        account.setBalance(2000);
        account.withdraw(200);
        Assertions.assertEquals(1800, account.getBalance());
    }

    @Test
    public void testDeposti(){
        account.setBalance(2000);
        account.deposit(800);
        Assertions.assertEquals(2800, account.getBalance());
    }

    @Test
    public void testIfTotalAccountBalanceChangesWithSavingAndCurrent(){
        SavingsAccount savingsAccount = new SavingsAccount(user);
        CurrentAccount currentAccount = new CurrentAccount(user);

        savingsAccount.deposit(4000);
        currentAccount.deposit(200);

        Assertions.assertEquals(4000, savingsAccount.getBalance());
        Assertions.assertEquals(200, currentAccount.getBalance());
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void testTransactionLog(){
        account.setBalance(30);
        account.deposit(20000);
        account.withdraw(400);
        System.out.println(account.getTransactionLog());
    }
}
