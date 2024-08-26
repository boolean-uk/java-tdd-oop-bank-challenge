package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCore{

    @Test
    public void testDeposit(){
        Customer customer1 = new Customer("customer1");
        Assertions.assertTrue(customer1.getCurrent().getTransactions().isEmpty());
        Assertions.assertEquals(500, customer1.getCurrent().deposit(500).getBalance());
        Assertions.assertEquals(750, customer1.getCurrent().deposit(250).getBalance());
    }

    /*@Test
    public void testAddAccount(){
        Customer customer1 = new Customer("customer1");
        Assertions.assertTrue(customer1.getAccounts().isEmpty());
        customer1.addAccount("current");
        customer1.addAccount("SAVINGS");
        customer1.addAccount("test");
        Assertions.assertFalse(customer1.getAccounts().isEmpty());
        Assertions.assertEquals(2, customer1.getAccounts().size());
    }*/

    /*@Test
    public void testFindingSpecificAccount(){
        Customer customer1 = new Customer("customer1");
        customer1.addAccount("current");
        customer1.addAccount("savings");
        Assertions.assertTrue(customer1.getAccounts().contains("current"));
    }*/

    /*
    @Test
    public void testDeposit(){
        Customer customer1 = new Customer("customer1");
        customer1.addAccount("current");
        Assertions.assertEquals(0, );
        Assertions.assertEquals(500, );
    }
    */

}
