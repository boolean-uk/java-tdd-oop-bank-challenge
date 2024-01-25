package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void testCurrentAccountConstructor() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Account account = new Account("1", customer);
        Assertions.assertEquals("1", account.getAccountId());
        Assertions.assertEquals(customer, account.getCustomer());
        Assertions.assertEquals(0.0, account.getBalance());
    }

}