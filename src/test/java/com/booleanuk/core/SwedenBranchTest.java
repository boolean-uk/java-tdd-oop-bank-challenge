package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwedenBranchTest {

    @Test
    public void testAccountCreation() {
        SwedenBranch sweden = new SwedenBranch();
        sweden.createAndAddAccount(12345678, Branch.Type.CURRENT);
        Assertions.assertEquals(2, sweden.getAccounts().getFirst().getPrefix());
        Assertions.assertEquals(12345678, sweden.getAccounts().getFirst().getAccountNumber());
        Assertions.assertInstanceOf(CurrentAccount.class, sweden.getAccounts().getFirst());
    }

    @Test
    public void testValidOverdraftRequestCurrent() {
        SwedenBranch sweden = new SwedenBranch();
        sweden.createAndAddAccount(12345678, Branch.Type.CURRENT);
        sweden.getAccounts().getFirst().requestOverdraft(50.0);
        sweden.handleOverdraftRequest(50.0, sweden.getAccounts().getFirst());
        Assertions.assertEquals(-50.0, sweden.getAccounts().getFirst().getLimit());
        //also check if that account now can actually use the overdraft
        sweden.getAccounts().getFirst().makeTransaction(-40.0);
        Assertions.assertEquals(-40.0, sweden.getAccounts().getFirst().getBalance());
    }

    @Test
    public void testInvalidOverdraftRequest() {
        SwedenBranch sweden = new SwedenBranch();
        sweden.createAndAddAccount(12345678, Branch.Type.CURRENT);
        sweden.getAccounts().getFirst().requestOverdraft(1001.0);
        sweden.handleOverdraftRequest(1001.0, sweden.getAccounts().getFirst());
        //Limit should not have changed since 1001 > 1000
        Assertions.assertEquals(0.0, sweden.getAccounts().getFirst().getLimit());
        //also check if that account can't use the overdraft
        sweden.getAccounts().getFirst().makeTransaction(-400.0);
        Assertions.assertEquals(0.0, sweden.getAccounts().getFirst().getBalance());

    }

    @Test
    public void testOverdraftRequestSavings() {
        SwedenBranch sweden = new SwedenBranch();
        sweden.createAndAddAccount(12345678, Branch.Type.SAVINGS);
        sweden.getAccounts().getFirst().requestOverdraft(50.0);
        sweden.handleOverdraftRequest(50.0, sweden.getAccounts().getFirst());
        Assertions.assertEquals(0.0, sweden.getAccounts().getFirst().getLimit());
        //also check if that account still can't use the overdraft
        sweden.getAccounts().getFirst().makeTransaction(-40.0);
        Assertions.assertEquals(0.0, sweden.getAccounts().getFirst().getBalance());
    }
}
