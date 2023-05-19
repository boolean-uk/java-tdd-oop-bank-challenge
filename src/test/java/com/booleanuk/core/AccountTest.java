package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testAccountCreation(){
        Bank bank = new Bank();
        Assertions.assertEquals(0, bank.getAccounts().size());
        Customer customer = new Customer(1);
        Assertions.assertTrue(customer.createAccount("current", 400));
        Assertions.assertEquals(1, bank.getAccounts().size());
        Assertions.assertTrue(customer.createAccount("savings", 930));
        Customer customer2 = new Customer(2);
        Assertions.assertTrue(customer2.createAccount("savings", 9020));
        Assertions.assertEquals(3, account.getAccounts().size());
    }
}
