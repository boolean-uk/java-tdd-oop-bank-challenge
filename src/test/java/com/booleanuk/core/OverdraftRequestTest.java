package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OverdraftRequestTest {

    @Test
    public void testCustomerCanRequestOverdraft () {
        Bank bank = new Bank();
        bank.addCustomer(1);
        Customer customer = bank.getCustomers().get(0);

        Assertions.assertTrue(customer.createCurrentAccount(7000));
        Assertions.assertEquals("You have not requested overdraft", customer.getOverdraftRequestStatus());

        customer.requestOverdraft(7500);
        Assertions.assertEquals("Not evaluated", customer.getOverdraftRequestStatus());

        bank.addCustomer(2);
        customer = bank.getCustomers().get(1);
        Assertions.assertTrue(customer.createCurrentAccount(520));
        customer.requestOverdraft(1200);

        Assertions.assertEquals(2, Bank.getOverdraftRequests().size());
    }


    //test for approval or rejection of overdrafts is done in the main class
}