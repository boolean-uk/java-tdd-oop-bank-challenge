package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testAddCustomer(){
        Customer customer = new Customer("1111-1111-1111", "Alexander Ellnestam", "ABC123");
        Assertions.assertEquals("1111-1111-1111", customer.getAccountNum());
        Assertions.assertEquals("Alexander Ellnestam", customer.getName());
        Assertions.assertEquals("ABC123", customer.getBranchNum());
    }

    @Test
    public void testCurrentCustomerAccount(){
        CurrentCustomerAccount cca = new CurrentCustomerAccount("1111-1111-1111", "Alexander Ellnestam", "ABC123");
        Assertions.assertEquals("1111-1111-1111", cca.getAccountNum());
        Assertions.assertEquals("Alexander Ellnestam", cca.getName());
        Assertions.assertEquals("ABC123", cca.getBranchNum());
    }

    @Test
    public void testCustomerSavingAccount(){
        CustomerSavingAccount csa = new CustomerSavingAccount("1111-1111-1111", "Alexander Ellnestam", "ABC123");
        Assertions.assertEquals("1111-1111-1111", csa.getAccountNum());
        Assertions.assertEquals("Alexander Ellnestam", csa.getName());
        Assertions.assertEquals("ABC123", csa.getBranchNum());
    }

}
