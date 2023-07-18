package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAccount {
    @Test
    public void testCurrentAccount() {
        Account currentAcc = new CurrentAccount("NDBK-0000-0001", "Aidan", "van Geest", "ROT001");
        Assertions.assertEquals("NDBK-0000-0001", currentAcc.getAccountNumber());
        Assertions.assertEquals("Aidan", currentAcc.getAccountHolderFirstName());
        Assertions.assertEquals("van Geest", currentAcc.getAccountHolderLastName());
        Assertions.assertEquals("ROT001", currentAcc.getBranchCode());
    }

    @Test
    public void testSavingsAccount() {
        Account savingsAcc = new SavingsAccount("NDBK-0000-0002", "Aidan", "van Geest", "ROT001");
        Assertions.assertEquals("NDBK-0000-0002", savingsAcc.getAccountNumber());
        Assertions.assertEquals("Aidan", savingsAcc.getAccountHolderFirstName());
        Assertions.assertEquals("van Geest", savingsAcc.getAccountHolderLastName());
        Assertions.assertEquals("ROT001", savingsAcc.getBranchCode());
    }

    @Test
    public void testCentsToDollars() {
        Account currentAcc = new CurrentAccount("NDBK-0000-0001", "Aidan", "van Geest", "ROT001");
        currentAcc.setBalanceInCents(50.45);
        Assertions.assertEquals(5045, currentAcc.getBalanceInCents());
        Assertions.assertEquals(50.45, currentAcc.getBalanceInDollars());
    }



}
