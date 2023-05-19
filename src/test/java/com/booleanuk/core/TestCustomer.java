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
    @Test
    public void testSetUpAccount(){
        Customer myself = new Customer("Dennis Voutos","Athens Greece","26/03/1998",12345);
        myself.setUpAccount(new Balance(10,0));
        Assertions.assertEquals(10,myself.getAccount().getBalance().getIntPart());
        Customer mother = new Customer("Katsarou P.","Zante Greece", "Never say a woman's age",6789);
        mother.setUpAccount(new Balance(-1,0)); // error message prints correctly
    }
}
