package com.booleanuk.core;

import com.booleanuk.core.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
    Customer customer;
    @BeforeEach
    public void Setup()
    {
         customer = new Customer();
    }
    @Test
    public void customerCreateAccountTest_shouldBeAddedToCustomerAccountsList()
    {
        customer.createAccount("currentAccount");
        Assertions.assertEquals(1,customer.getAccountsList().size());
    }

}