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
}
