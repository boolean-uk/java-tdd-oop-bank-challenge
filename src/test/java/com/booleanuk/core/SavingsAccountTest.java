package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    public void testCurrentAccountConstructor() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Account savingsAccount = new SavingsAccount("1", customer);
        Assertions.assertEquals("1", savingsAccount.getAccountId());
        Assertions.assertEquals(customer, savingsAccount.getCustomer());
        Assertions.assertEquals(0.0, savingsAccount.getBalance());
    }
}