package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSavingsAccount {
    @Test
    public void testSavingsAccount() {
        SavingsAccount savingsAcc = new SavingsAccount("NDBK-0000-0002", "Aidan", "van Geest", "ROT001");
        Assertions.assertEquals("NDBK-0000-0002", savingsAcc.getAccountNumber());
        Assertions.assertEquals("Aidan", savingsAcc.getAccountHolderFirstName());
        Assertions.assertEquals("van Geest", savingsAcc.getAccountHolderLastName());
        Assertions.assertEquals("ROT001", savingsAcc.getBranchCode());
    }
}
