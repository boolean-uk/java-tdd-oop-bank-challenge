package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAccount {
    @Test
    public void testCurrentAccount() {
        Account currentAcc = new CurrentAccount("NDBK-0000-0001", "Aidan", "van Geest", "ROT001");
        Assertions.assertEquals("NDBK-0000-0001", currentAcc.accountNumber);
        Assertions.assertEquals("Aidan", currentAcc.accountHolderFirstName);
        Assertions.assertEquals("van Geest", currentAcc.accountHolderLastName);
        Assertions.assertEquals("ROT001", currentAcc.branchCode);
    }

    @Test
    public void testSavingsAccount() {
        Account savingsAcc = new SavingsAccount("NDBK-0000-0002", "Aidan", "van Geest", "ROT001");
        Assertions.assertEquals("NDBK-0000-0002", savingsAcc.accountNumber);
        Assertions.assertEquals("Aidan", savingsAcc.accountHolderFirstName);
        Assertions.assertEquals("van Geest", savingsAcc.accountHolderLastName);
        Assertions.assertEquals("ROT001", savingsAcc.branchCode);
    }



}
