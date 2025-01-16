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
}
