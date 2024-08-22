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
    public void testBranchOverdraftMap() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);

        branch.addOverdraftRequest(account, 500.0);
        Assertions.assertFalse(branch.getOverdraftRequests().isEmpty());
        Assertions.assertEquals(500.0,branch.getOverdraftRequests().get(account));
    }

    @Test
    public void testDeclineOverdraftRequest() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);

        branch.addOverdraftRequest(account, 500.0);

        Assertions.assertEquals("Request for account 1 declined",branch.reviewOverdraftRequest("1",false));
    }

    @Test
    public void testAcceptOverdraftRequest() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);

        branch.addOverdraftRequest(account, 500.0);

        Assertions.assertEquals(0, account.getOverdraftLimit());
        Assertions.assertEquals("Request for account 1 accepted",branch.reviewOverdraftRequest("1",true));
        Assertions.assertEquals(500, account.getOverdraftLimit());
    }

    @Test
    public void testReviewNoneExistingOverdraftRequest() {
        Branch branch = new Branch("1", "DNC", "London");

        Assertions.assertEquals("No request found",branch.reviewOverdraftRequest("1",true));
    }
}