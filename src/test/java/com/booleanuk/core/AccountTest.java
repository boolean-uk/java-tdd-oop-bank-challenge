package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void makeCurrentAccountTest() {
        Account account = new CurrentAccount(500);
        Assertions.assertNotNull(account, "The account should be created");
    }

    @Test
    public void checkBalance() {
        Account account = new CurrentAccount(500);
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public  void DepositTest() {
        Account account = new CurrentAccount(500);
        account.deposit(100);
        Assertions.assertEquals(600, account.getBalance());

    }

    @Test
    public  void WithdrawalTest() {
        Account account = new CurrentAccount(500);
        account.withdraw(100);
        Assertions.assertEquals(400, account.getBalance());

    }

    @Test
    public  void NegativeDepositTest() {
        Account account = new CurrentAccount(500);
        Assertions.assertEquals("The amount should be positive!", account.deposit(-100));

    }

    @Test
    public void withdrawalTestIfAmountExceedsLimit() {
        Account account = new CurrentAccount(500);
        Assertions.assertEquals("You dont have enough money for this withdrawal!", account.withdraw(600));


    }



}
