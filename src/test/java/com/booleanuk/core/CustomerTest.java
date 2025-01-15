package com.booleanuk.core;

import com.booleanuk.core.bank.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    public CustomerTest() {

    }

    @Test
    public void testCustomerCreate() {
        Customer c = new Customer();

        Assertions.assertEquals("", c.getId());
    }

}
