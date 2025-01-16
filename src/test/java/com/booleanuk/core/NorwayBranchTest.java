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
}
