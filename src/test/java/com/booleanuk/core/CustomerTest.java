package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    public CustomerTest() {

    }

    @Test
    public void testCustomerCreate() {
        Customer c = new Customer("ID1");

        Assertions.assertEquals("ID1", c.getId());
    }

}
