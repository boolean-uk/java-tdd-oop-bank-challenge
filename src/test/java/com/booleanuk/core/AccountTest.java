package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testAccountCreation(){
        Bank bank = new Bank();
        bank.addCustomer(1);
        Customer customer = bank.getCustomers().get(0);
        Assertions.assertTrue(customer.createCurrentAccount(400));
        Assertions.assertEquals(1, bank.getAccounts().size());
        Assertions.assertTrue(customer.createSavingsAccount(930));
        Customer customer2 = new Customer(2);
        Assertions.assertTrue(customer2.createSavingsAccount(9020));
        Assertions.assertEquals(3, bank.getAccounts().size());
    }
}
