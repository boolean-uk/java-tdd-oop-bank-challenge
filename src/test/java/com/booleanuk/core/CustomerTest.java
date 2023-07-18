package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void shouldCreateCurrentAccount() {
        int customerId = 1;
        Customer customer = new Customer(customerId);

        Assertions.assertTrue(customer.createCurrentAccount("current", 1000));
        Assertions.assertEquals(1, customer.getAccounts().size());
        Assertions.assertEquals("current", customer.getAccounts().get(0).getType());
    }

    @Test
    public void shouldCreateSavingsAccount() {
        int customerId = 1;
        Customer customer = new Customer(customerId);

        Assertions.assertTrue(customer.createSavingsAccount("savings", 2000));
        Assertions.assertEquals(1, customer.getAccounts().size());
        Assertions.assertEquals("savings", customer.getAccounts().get(0).getType());
    }
    @Test
    public void shouldWithdraw() {
        int customerId = 123;
        Customer customer = new Customer(customerId);
        customer.createCurrentAccount("current", 1000);

        Assertions.assertTrue(customer.withdraw(300, "current"));

        int expectedBalance = 700;
        int actualBalance = customer.getAccounts().get(0).getBalance();
        Assertions.assertEquals(expectedBalance, actualBalance);
    }
}
