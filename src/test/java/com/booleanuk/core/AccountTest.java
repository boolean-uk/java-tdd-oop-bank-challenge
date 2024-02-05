package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void createAccountSavingAndCurrent(){

        Account account = new Account();

        Assertions.assertTrue(account.addAccount("Current","1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertTrue(account.addAccount("Savings","2222-2222-2222", "Alexander Ellnestam", "ABC123"));

    }

    @Test
    public void invalidAccountSavingAndCurrent(){

        Account account = new Account();

        Assertions.assertTrue(account.addAccount("Current","1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertFalse(account.addAccount("Current","1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertFalse(account.addAccount("Current and Saving","3222-2222-2222", "Alexander Ellnestam", "ABC123"));

    }

    @Test
    public void findAccountTest(){

        Account account = new Account();

        account.addAccount("Current","1111-1111-1111", "Alexander Ellnestam", "ABC123");

        Assertions.assertEquals(account.customerAccounts.get(0), account.findAccount("1111-1111-1111"));

        Assertions.assertNull(account.findAccount("1111-1111"));


    }

}
