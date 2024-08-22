package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void testCreateBankInstance() {
        Bank bank = new Bank("Bank");
        Assertions.assertNotNull(bank);
    }

    @Test
    public void testAddCustomer() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Assertions.assertTrue(bank.addCustomer(customer));
        Assertions.assertFalse(bank.addCustomer(customer));
    }

    @Test
    public void testGetCustomers() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        bank.addCustomer(customer);
        Assertions.assertEquals(1, bank.getCustomers().size());
    }
}
