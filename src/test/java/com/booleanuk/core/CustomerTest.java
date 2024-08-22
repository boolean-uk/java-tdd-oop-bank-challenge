package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testCreateCustomerInstance() {
        Customer customer = new Customer("Name");
        Assertions.assertNotNull(customer);
    }

    @Test
    public void testRequestCurrentAccount() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        bank.addCustomer(customer);
        Assertions.assertTrue(customer.requestCurrentAccount());
    }

    @Test
    public void testGetAccounts() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Assertions.assertEquals(0, customer.getAccounts().size());
    }
}
