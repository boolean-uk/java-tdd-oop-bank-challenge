package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCore{

    @Test
    public void testAddAccount(){
        Customer customer1 = new Customer("customer1");
        Assertions.assertTrue(customer1.getAccounts().isEmpty());
        customer1.addAccount("current");
        Assertions.assertFalse(customer1.getAccounts().isEmpty());
    }
}
