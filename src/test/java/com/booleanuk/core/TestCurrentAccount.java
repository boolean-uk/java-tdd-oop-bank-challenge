package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCurrentAccount {
    @Test
    public void testCurrentAccount() {
        CurrentAccount currentAcc = new CurrentAccount("NDBK-0000-0001", "Aidan", "van Geest", "ROT001");
        Assertions.assertEquals("NDBK-0000-0001", currentAcc.getAccountNumber());
        Assertions.assertEquals("Aidan", currentAcc.getAccountHolderFirstName());
        Assertions.assertEquals("van Geest", currentAcc.getAccountHolderLastName());
        Assertions.assertEquals("ROT001", currentAcc.getBranchCode());
    }



}
