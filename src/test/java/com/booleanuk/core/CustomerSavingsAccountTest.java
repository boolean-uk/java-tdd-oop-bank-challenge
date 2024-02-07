package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerSavingsAccountTest {
    @Test
    public void testCustomerSavingAccount(){
        CustomerSavingAccount csa = new CustomerSavingAccount("1111-1111-1111", "Alexander Ellnestam", "ABC123");
        Assertions.assertEquals("1111-1111-1111", csa.getAccountNum());
        Assertions.assertEquals("Alexander Ellnestam", csa.getName());
        Assertions.assertEquals("ABC123", csa.getBranchNum());
    }
}
