package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void openCurrentAccount(){
        Assertions.assertEquals("Opened a new current account: 'Test Current'.", openAccount("Test Current"));
        Assertions.assertTrue(Customer.getAccounts().size == 1);
    }

    @Test
    public void openSavingsAccount(){
        Assertions.assertEquals("Opened a new savings account: 'Test Savings'.", openAccount("Test Savings"));
        Assertions.assertTrue(Customer.getAccounts().size == 1);
    }
}
