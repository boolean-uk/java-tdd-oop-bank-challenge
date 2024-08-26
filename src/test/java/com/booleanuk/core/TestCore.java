package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestCore{

    @Test
    public void testDeposit(){
        Customer customer1 = new Customer("customer1");
        Assertions.assertTrue(customer1.getCurrent().getTransactions().isEmpty());
        Assertions.assertEquals(500, customer1.getCurrent().deposit(500).getCredit());
        Assertions.assertEquals(LocalDate.now(), customer1.getCurrent().deposit(100).getDate());
        Assertions.assertEquals(1, customer1.getCurrent().getTransactions().size());
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
