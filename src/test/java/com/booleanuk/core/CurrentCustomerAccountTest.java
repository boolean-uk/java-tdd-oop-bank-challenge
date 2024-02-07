package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentCustomerAccountTest {

    @Test
    public void testCurrentCustomerAccount(){
        CurrentCustomerAccount cca = new CurrentCustomerAccount("1111-1111-1111", "Alexander Ellnestam", "ABC123");
        Assertions.assertEquals("1111-1111-1111", cca.getAccountNum());
        Assertions.assertEquals("Alexander Ellnestam", cca.getName());
        Assertions.assertEquals("ABC123", cca.getBranchNum());
    }
}
