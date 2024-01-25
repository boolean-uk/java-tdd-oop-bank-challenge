package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void testCustomerConstructor() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Assertions.assertEquals("1", customer.getCustomerId());
        Assertions.assertEquals("Java Man", customer.getName());
        Assertions.assertEquals("12345678", customer.getPhoneNumber());
        Assertions.assertEquals("java@man.coder", customer.getEmail());
    }

}