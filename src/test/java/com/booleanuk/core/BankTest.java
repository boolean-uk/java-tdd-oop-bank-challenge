package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void testCreateBankInstance() {
        Bank bank = new Bank("Bank");
        Assertions.assertNotNull(bank);
        Assertions.assertEquals("Bank", bank.getName());
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
        Customer customer1 = new Customer("Name");
        Customer customer2 = new Customer("Name");
        bank.addCustomer(customer1);
        Assertions.assertEquals(1, bank.getCustomers().size());
        Assertions.assertTrue(bank.getCustomers().contains(customer1));

        bank.addCustomer(customer2);
        Assertions.assertEquals(2, bank.getCustomers().size());
        Assertions.assertTrue(bank.getCustomers().contains(customer1));
        Assertions.assertTrue(bank.getCustomers().contains(customer2));

        Customer customer3 = new Customer("Name");
        Assertions.assertFalse(bank.getCustomers().contains(customer3));
    }

    @Test
    public void testCreateCurrentAccount() {
        Bank bank = new Bank("Bank");
        Customer customer1 = new Customer("Name");
        bank.addCustomer(customer1);

        Assertions.assertTrue(bank.createCurrentAccount(customer1));
    }
}
