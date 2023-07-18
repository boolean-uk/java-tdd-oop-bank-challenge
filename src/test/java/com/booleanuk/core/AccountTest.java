package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    CurrentAccount myAccount = new CurrentAccount();

    @Test
    public void testAccount() {
        Assertions.assertNotNull(myAccount);
    }

    @Test
    public void testAccountNumber() {

        myAccount.setAccountNumber("C123456789");

        Assertions.assertEquals("C123456789", myAccount.getAccountNumber());
    }

    @Test
    public void testGetAccountBalance() {

        myAccount.setBalance(1000);

        Assertions.assertEquals(1000, myAccount.getBalance());
    }

    @Test
    public void testDeposit() {

        myAccount.setBalance(1000);
        myAccount.deposit(1000);
        myAccount.deposit(1000);
        myAccount.deposit(1000);

        Assertions.assertEquals(4000, myAccount.getBalance());
    }

    @Test
    public void testWithdraw() {

        myAccount.setBalance(1000);
        myAccount.deposit(1000);
        myAccount.deposit(1000);
        myAccount.deposit(1000);

        myAccount.withdraw(4000);

        Assertions.assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void testWithdrawWithNoMoney() {

        myAccount.setBalance(1000);

        myAccount.withdraw(4000);

        Assertions.assertEquals(1000, myAccount.getBalance());
    }

    @Test
    public void testCurrentWithdraw() {

        myAccount.setBalance(1000);
        myAccount.deposit(1000);
        myAccount.deposit(1000);
        myAccount.deposit(1000);

        myAccount.withdraw(4000);

        Assertions.assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void testCurrentWithdrawWithOverdraft() {

        myAccount.setBalance(1000);
        myAccount.deposit(1000);
        myAccount.deposit(1000);
        myAccount.deposit(1000);

        myAccount.setOverdraftLimit(1000);

        myAccount.withdraw(5000);

        Assertions.assertEquals(-1000, myAccount.getBalance());
    }

    @Test
    public void testCurrentWithdrawWithOverdraft2() {

        myAccount.setBalance(500);

        myAccount.setOverdraftLimit(500);

        myAccount.withdraw(1000);

        Assertions.assertEquals(-500, myAccount.getBalance());
    }

}
