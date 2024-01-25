package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    @Test
    public void testBranchConstructor() {
        Branch branch = new Branch("1", "DNC", "London");
        Assertions.assertEquals("1", branch.getBranchId());
        Assertions.assertEquals("DNC", branch.getName());
        Assertions.assertEquals("London", branch.getLocation());
        Assertions.assertTrue(branch.getOverdraftRequests().isEmpty());
    }

    @Test
    public void testBranchOverdraftMapInitialized() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        branch.getOverdraftRequests().put(account, 500.0);
        Assertions.assertFalse(branch.getOverdraftRequests().isEmpty());
        Assertions.assertEquals(500.0,branch.getOverdraftRequests().get(account));
    }
}