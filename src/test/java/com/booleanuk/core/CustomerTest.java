package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void CustomerExistTest() {
        Customer customer = new Customer("Abdul", "Khan");
        Assertions.assertEquals("Abdul", customer.getFirstName());
        Assertions.assertEquals("Khan", customer.getLastName());
    }
}
