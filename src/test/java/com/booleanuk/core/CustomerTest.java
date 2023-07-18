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
    @Test
    public void customerWithdrawMoney_notEnoughMoney()
    {
        customer.createAccount("currentAccount");
        boolean result = customer.withdrawMoney(0,200);
        Assertions.assertFalse(result);
    }
    @Test
    public void customerWithdrawMoney_EnoughMoney()
    {
        customer.createAccount("currentAccount");
        customer.depositMoney(0,200);
        boolean result = customer.withdrawMoney(0,200);
        Assertions.assertTrue(result);
    }

}