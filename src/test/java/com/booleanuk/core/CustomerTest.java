package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testCustomerCanCreateOnlyOneCurrentAndSavingsAccount(){
        Bank bank = new Bank();
        bank.addCustomer(3);
        Customer customer = bank.getCustomers().get(0);
        Assertions.assertTrue(customer.createCurrentAccount(500));
        Assertions.assertFalse(customer.createCurrentAccount(500));
        Assertions.assertTrue(customer.createSavingsAccount(5000));
        Assertions.assertFalse(customer.createSavingsAccount(5000));
    }

    @Test
    public void testDeposit(){
        Bank bank = new Bank();
        bank.addCustomer(3);
        Customer customer = bank.getCustomers().get(0);

        Assertions.assertTrue(customer.createCurrentAccount(500));
        Assertions.assertTrue(customer.deposit("current", 200));
        Assertions.assertEquals(700, customer.getCurrentAccount().getBalance());

        Assertions.assertTrue(customer.deposit("current", 400));
        Assertions.assertEquals(1100, customer.getCurrentAccount().getBalance());

        Assertions.assertFalse(customer.deposit("savings", 200));

    }

    @Test
    public void testWithdraw(){
        Bank bank = new Bank();
        Customer customer = new Customer(5);

        Assertions.assertTrue(customer.createCurrentAccount(5000));
        Assertions.assertTrue(customer.withdraw("current", 200));
        Assertions.assertEquals(4800, customer.getCurrentAccount().getBalance());

        Assertions.assertTrue(customer.withdraw("current", 1000));
        Assertions.assertEquals(3800, customer.getCurrentAccount().getBalance());

        Assertions.assertFalse(customer.withdraw("current", 4000));

        Assertions.assertTrue(customer.createSavingsAccount(1000));
        Assertions.assertTrue(customer.withdraw("savings", 200));
        Assertions.assertFalse(customer.withdraw("savings", 210));
        Assertions.assertFalse(customer.withdraw("savings", 250));

    }
}
