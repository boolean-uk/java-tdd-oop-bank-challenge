package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        Assertions.assertEquals(1, customer.getAccounts().size());
    }

    @Test
    public void testGetAccounts() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Assertions.assertEquals(0, customer.getAccounts().size());
    }

    @Test
    public void testSetAccounts() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Account account = new Account();
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        customer.setAccounts(accounts);
        Assertions.assertEquals(1, customer.getAccounts().size());
    }

    @Test
    public void testGetBank() {
        Customer customer = new Customer("Name");
        Assertions.assertNull(customer.getBank());
    }

}
