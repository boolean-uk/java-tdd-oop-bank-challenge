package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    public BankTest() {

    }

    @Test
    public void testCreateBank() {
        Bank bank = new Bank("Swedbank");

        Assertions.assertEquals("Swedbank", bank.getName());
    }

    @Test
    public void testAddCustomerToBank() {
        Bank bank = new Bank("Swedbank");
        bank.addCustomer(new Customer());

        Assertions.assertEquals(10, bank.getCustomers().getFirst().getId().length());
    }

    @Test
    public void testAddAccountToCustomer() {
        Bank bank = new Bank("Swedbank");
        Customer newCustomer = bank.addCustomer(new Customer());
        Account newAccount = bank.newAccount(newCustomer, new CurrentAccount());

        Assertions.assertTrue(newCustomer.getAccounts().size() == 1);
        Assertions.assertEquals(newCustomer.getAccounts().getFirst().getAccountNumber(), newAccount.getAccountNumber());
    }

}
