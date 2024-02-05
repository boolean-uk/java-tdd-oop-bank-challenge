package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void createAccount(){

        Account account = new Account();

        Assertions.assertTrue(account.addAccount("Savings","1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertTrue(account.addAccount("Current","1111-1111-1111", "Alexander Ellnestam", "ABC123"));
    }

}
