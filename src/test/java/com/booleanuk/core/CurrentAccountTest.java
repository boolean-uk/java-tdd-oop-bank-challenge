package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentAccountTest {

    @Test
    public void testCurrentAccountConstructor() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account currentAccount = new CurrentAccount("1", customer, branch);
        Assertions.assertEquals("1", currentAccount.getAccountId());
        Assertions.assertEquals(customer, currentAccount.getCustomer());
        Assertions.assertEquals(branch, currentAccount.getBranch());
        Assertions.assertEquals(0.0, currentAccount.getBalance());
    }

}