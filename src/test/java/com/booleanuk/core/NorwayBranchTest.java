package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NorwayBranchTest {

    @Test
    public void testAccountCreation() {
        NorwayBranch norway = new NorwayBranch();
        norway.createAndAddAccount(12345678, Branch.Type.CURRENT);
        Assertions.assertEquals(1, norway.getAccounts().getFirst().getPrefix());
        Assertions.assertEquals(12345678, norway.getAccounts().getFirst().getAccountNumber());
        Assertions.assertInstanceOf(CurrentAccount.class, norway.getAccounts().getFirst());
    }

    @Test
    public void testValidOverdraftRequestCurrent() {
        NorwayBranch norway = new NorwayBranch();
        norway.createAndAddAccount(12345678, Branch.Type.CURRENT);
        norway.getAccounts().getFirst().requestOverdraft(500.0);
        norway.handleOverdraftRequest(500.0, norway.getAccounts().getFirst());
        Assertions.assertEquals(-500.0, norway.getAccounts().getFirst().getLimit());
        //also check if that account now can actually use the overdraft
        norway.getAccounts().getFirst().makeTransaction(-400.0);
        Assertions.assertEquals(-400.0, norway.getAccounts().getFirst().getBalance());
    }

    @Test
    public void testInvalidOverdraftRequest() {
        NorwayBranch norway = new NorwayBranch();
        norway.createAndAddAccount(12345678, Branch.Type.CURRENT);
        norway.getAccounts().getFirst().requestOverdraft(1001.0);
        norway.handleOverdraftRequest(1001.0, norway.getAccounts().getFirst());
        //Limit should not have changed since 1001 > 1000
        Assertions.assertEquals(0.0, norway.getAccounts().getFirst().getLimit());
        //also check if that account can't use the overdraft
        norway.getAccounts().getFirst().makeTransaction(-400.0);
        Assertions.assertEquals(0.0, norway.getAccounts().getFirst().getBalance());

    }

    @Test
    public void testOverdraftRequestSavings() {
        NorwayBranch norway = new NorwayBranch();
        norway.createAndAddAccount(12345678, Branch.Type.SAVINGS);
        norway.getAccounts().getFirst().requestOverdraft(500.0);
        norway.handleOverdraftRequest(500.0, norway.getAccounts().getFirst());
        Assertions.assertEquals(0.0, norway.getAccounts().getFirst().getLimit());
        //also check if that account still can't use the overdraft
        norway.getAccounts().getFirst().makeTransaction(-400.0);
        Assertions.assertEquals(0.0, norway.getAccounts().getFirst().getBalance());
    }
}
