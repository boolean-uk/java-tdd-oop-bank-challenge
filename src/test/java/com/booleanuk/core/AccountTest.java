package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void testDepositFunds(){
        Account account = new Account();
        account.depositFunds(5.00);
        System.out.println(account.transactions.get(0).getTransactionAmount());
        Assertions.assertEquals(5,account.transactions.get(0).getTransactionAmount());
    }

    @Test
    public void testgetBalance(){
        Account account = new Account();
        account.depositFunds(5.00);
        System.out.println(account.getBalance());
        Assertions.assertEquals(5,account.getBalance());
    }

    @Test
    public void testWithdrawFunds(){
        Account account = new Account();
        account.depositFunds(5.00);
        account.withdrawFunds(-5.00);
        System.out.println(account.getBalance());
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void testgenerateStatement(){
        Account account = new Account();
        account.depositFunds(5.00);
        account.withdrawFunds(-5.00);
        System.out.println(account.getBalance());
        Assertions.assertEquals(0, account.getBalance());
    }
}
