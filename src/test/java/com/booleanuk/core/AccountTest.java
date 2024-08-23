package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void makeAccountTest() {
        Account account = new Account(500);
        Assertions.assertNotNull(account, "The account should be created");
    }

    @Test
    public void checkBalance() {
        Account account = new Account(500);
        Assertions.assertEquals(500, account.getBalance());
    }

}
