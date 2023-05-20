package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCustomer {
    @Test
    public void testConstructor(){
        Customer myself = new Customer("Dennis Voutos","Athens Greece","26/03/1998",12345);
        Assertions.assertEquals("Dennis Voutos",myself.getName());
        Assertions.assertEquals("Athens Greece",myself.getAddress());
        Assertions.assertEquals("26/03/1998",myself.getDateOfBirth());
        Assertions.assertEquals(12345,myself.getTaxpayerIdentificationNumber());
    }
    //these tests will change because of the changes of our project
    @Test
    public void testSetUpAccount(){
        Customer myself = new Customer("Dennis Voutos","Athens Greece","26/03/1998",12345);
        myself.setUpSavingsAccount(0,1);

        Assertions.assertEquals(0,myself.getAccounts().size());
        //As a design choice, i don't want accounts with null balance for a user. so i made a function to remove all these accounts.
    }
}
