package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UKBranchTest {

    @Test
    public void testAccountCreation() {
        UKBranch uk = new UKBranch();
        uk.createAndAddAccount(12345678, Branch.Type.CURRENT);
        Assertions.assertEquals(3, uk.getAccounts().getFirst().getPrefix());
        Assertions.assertEquals(12345678, uk.getAccounts().getFirst().getAccountNumber());
        Assertions.assertInstanceOf(CurrentAccount.class, uk.getAccounts().getFirst());
    }

    @Test
    public void testValidOverdraftRequestCurrent() {
        UKBranch uk = new UKBranch();
        uk.createAndAddAccount(12345678, Branch.Type.CURRENT);
        uk.getAccounts().getFirst().requestOverdraft(50.0);
        uk.handleOverdraftRequest(50.0, uk.getAccounts().getFirst());
        Assertions.assertEquals(-50.0, uk.getAccounts().getFirst().getLimit());
        //also check if that account now can actually use the overdraft
        uk.getAccounts().getFirst().makeTransaction(-40.0);
        Assertions.assertEquals(-40.0, uk.getAccounts().getFirst().getBalance());
    }

    @Test
    public void testInvalidOverdraftRequest() {
        UKBranch uk = new UKBranch();
        uk.createAndAddAccount(12345678, Branch.Type.CURRENT);
        uk.getAccounts().getFirst().requestOverdraft(1001.0);
        uk.handleOverdraftRequest(1001.0, uk.getAccounts().getFirst());
        //Limit should not have changed since 1001 > 1000
        Assertions.assertEquals(0.0, uk.getAccounts().getFirst().getLimit());
        //also check if that account can't use the overdraft
        uk.getAccounts().getFirst().makeTransaction(-400.0);
        Assertions.assertEquals(0.0, uk.getAccounts().getFirst().getBalance());

    }

    @Test
    public void testOverdraftRequestSavings() {
        UKBranch uk = new UKBranch();
        uk.createAndAddAccount(12345678, Branch.Type.SAVINGS);
        uk.getAccounts().getFirst().requestOverdraft(50.0);
        uk.handleOverdraftRequest(50.0, uk.getAccounts().getFirst());
        Assertions.assertEquals(0.0, uk.getAccounts().getFirst().getLimit());
        //also check if that account still can't use the overdraft
        uk.getAccounts().getFirst().makeTransaction(-40.0);
        Assertions.assertEquals(0.0, uk.getAccounts().getFirst().getBalance());
    }

}
