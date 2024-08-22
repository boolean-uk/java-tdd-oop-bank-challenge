package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testCreateCustomerInstance() {
        Customer bank = new Customer("Name");
        Assertions.assertNotNull(bank);
    }
}
