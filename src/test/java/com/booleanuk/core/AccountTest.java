package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void depositMoneyTest(){
        Account account = new Account("Jan Lisek","00003");
        Assertions.assertEquals(0,account.getTransactionHistory().size());
        account.depositMoney(500);
        Assertions.assertEquals(500,account.getTransactionHistory().get(0).getAmount());
    }

    @Test
    public void withdrawMoneyMoneyTest(){
        Account account = new Account("Jan Lisek","00003");
        Assertions.assertEquals(0,account.getTransactionHistory().size());
        account.depositMoney(1000);
        Assertions.assertTrue(account.withdrawMoney(300));
        Assertions.assertEquals(300,account.getTransactionHistory().get(1).getAmount());
        Assertions.assertFalse(account.withdrawMoney(2000));
    }

    @Test
    public void calculateBalanceTest(){
        Account account = new Account("Jan Lisek","00003");
        account.depositMoney(1000);
        account.withdrawMoney(300);
        account.depositMoney(4000);
        Assertions.assertEquals(4700, account.calculateBalance());
    }
}
