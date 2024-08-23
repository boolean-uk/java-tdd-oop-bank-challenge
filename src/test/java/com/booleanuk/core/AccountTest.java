package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void makeAccountTest() {
        Customer customer = new Customer("Jeniston", "Antonsen");
        Account account = new Account(500,customer);
        Assertions.assertNotNull(account, "The account should be created");
    }

}
