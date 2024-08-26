package com.booleanuk.extension;

import com.booleanuk.core.Bank;
import com.booleanuk.core.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void testCreateBankInstance() {
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        Assertions.assertNotNull(bank);
        Assertions.assertEquals("Bank", bank.getName());
    }

    @Test
    public void testAddCustomer() {
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        Assertions.assertTrue(bank.addCustomer(customer));
        Assertions.assertEquals(bank, customer.getBank());
        Assertions.assertFalse(bank.addCustomer(customer));
    }

    @Test
    public void testGetCustomers() {
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        com.booleanuk.core.Customer customer1 = new com.booleanuk.core.Customer("Name");
        com.booleanuk.core.Customer customer2 = new com.booleanuk.core.Customer("Name");
        bank.addCustomer(customer1);
        Assertions.assertEquals(1, bank.getCustomers().size());
        Assertions.assertTrue(bank.getCustomers().contains(customer1));

        bank.addCustomer(customer2);
        Assertions.assertEquals(2, bank.getCustomers().size());
        Assertions.assertTrue(bank.getCustomers().contains(customer1));
        Assertions.assertTrue(bank.getCustomers().contains(customer2));

        com.booleanuk.core.Customer customer3 = new com.booleanuk.core.Customer("Name");
        Assertions.assertFalse(bank.getCustomers().contains(customer3), "Customer not added to the bank.");
    }

    @Test
    public void testCreateCurrentAccount() {
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        com.booleanuk.core.Customer customer1 = new com.booleanuk.core.Customer("Name");
        bank.addCustomer(customer1);

        Assertions.assertTrue(bank.createCurrentAccount(customer1));
        Assertions.assertEquals(1, customer1.getAccounts().size());

        com.booleanuk.core.Customer customer2 = new com.booleanuk.core.Customer("Name");
        Assertions.assertFalse(bank.createCurrentAccount(customer2), "Customer is not in the bank.");
    }

    @Test
    public void testCreateSavingsAccount() {
        com.booleanuk.core.Bank bank = new Bank("Bank");
        com.booleanuk.core.Customer customer1 = new com.booleanuk.core.Customer("Name");
        bank.addCustomer(customer1);

        Assertions.assertTrue(bank.createSavingsAccount(customer1));
        Assertions.assertEquals(1, customer1.getAccounts().size());

        com.booleanuk.core.Customer customer2 = new Customer("Name");
        Assertions.assertFalse(bank.createSavingsAccount(customer2), "Customer is not in the bank.");
    }
}
