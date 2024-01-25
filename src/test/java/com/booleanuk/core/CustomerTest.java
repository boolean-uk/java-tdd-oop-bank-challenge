package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    public void testCustomer(){
        Branch branch = new Branch("Oslo Branch");
        Customer customer = new Customer("Customer1", branch);
        Customer customer2 = new Customer("Customer2", branch);

        Assertions.assertEquals("Customer1", customer.getCustomerID());
        Assertions.assertEquals("Customer2", customer2.getCustomerID());

        Assertions.assertEquals(branch, customer.getCurrentAccount().getBranch());
        Assertions.assertEquals(branch, customer.getSavingsAccount().getBranch());

        Assertions.assertNotNull(customer.getSavingsAccount());
        Assertions.assertNotNull(customer2.getCurrentAccount());
    }
}
