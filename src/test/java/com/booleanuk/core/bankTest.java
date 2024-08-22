package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class bankTest {

    @Test
    public void createCurrentAccountTest() {
        Bank bank = new Bank();
        Assertions.assertTrue(bank.createCurrentAccount("1234C"));
    }
    @Test
    public void createExistingAccountTest() {
        Bank bank = new Bank();
        bank.createCurrentAccount("1234C");
        Assertions.assertFalse(bank.createCurrentAccount("1234C"));
        Assertions.assertEquals(1,bank.accounts.size());
    }

    @Test
    public void createSavingAccountTest() {
        Bank bank = new Bank();
        Assertions.assertTrue(bank.createSavingAccount("5678S"));
    }

    @Test
    public void createExistingAccountTest2() {
        Bank bank = new Bank();
        bank.createSavingAccount("5678S");
        Assertions.assertFalse(bank.createSavingAccount("5678S"));
        Assertions.assertEquals(1,bank.accounts.size());
    }

    @Test
    public void addFundsTest() {
        CurrentAccount account = new CurrentAccount("1234C", 0d);

        Assertions.assertEquals(100,account.addFunds(100));
    }

    @Test
    public void addFundsTestWithBalance() {
        CurrentAccount account = new CurrentAccount("1234C", 50d);

        Assertions.assertEquals(150,account.addFunds(100));
    }

    @Test
    public void withdrawTest() {
        CurrentAccount account = new CurrentAccount("1234C", 100d);

        Assertions.assertEquals(0,account.withdraw(100));
    }

    @Test
    public void withdrawNoBalance() {
        CurrentAccount account = new CurrentAccount("1234C", 0d);

        Assertions.assertEquals(0,account.withdraw(100));
    }

    @Test
    public void withdrawLowBalance() {
        CurrentAccount account = new CurrentAccount("1234C", 50d);

        Assertions.assertEquals(50,account.withdraw(100));
    }
    @Test
    public void WithdrawTest2() {
        CurrentAccount account = new CurrentAccount("1234C", 1000d);

        Assertions.assertEquals(900,account.withdraw(100));
    }

    @Test
    public void transaction() {
        Account account = new Account("123C", 100, "current");
        account.addFunds(250);
        account.withdraw(100);
        account.viewTransaction();
    }
}
