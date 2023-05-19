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
        myself.setUpSavingsAccount(100,1);
        myself.setUpCurrentAccount(150,0);
        myself.setUpCurrentAccount(200,1);
        //can set up many accounts of many types.
        Assertions.assertEquals(100,myself.getAccounts().get(0).getBalance().getIntPart());
        Assertions.assertEquals(150,myself.getAccounts().get(1).getBalance().getIntPart());
        Assertions.assertEquals(0,myself.getAccounts().get(1).getBalance().getDecimalPart());
    }
}
