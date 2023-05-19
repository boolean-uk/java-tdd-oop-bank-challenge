package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCurrentAccount {
    @Test
    public void testCurrentAccount() {
        CurrentAccount currentAcc = new CurrentAccount("BUNQ-0000-0001", "Aidan", "van Geest", "ROT001");
        Assertions.assertEquals("BUNQ-0000-0001", currentAcc.accountNumber);
        Assertions.assertEquals("Aidan", currentAcc.accountHolderFirstName);
        Assertions.assertEquals("van Geest", currentAcc.accountHolderLastName);
        Assertions.assertEquals("ROT001", currentAcc.branchCode);

    }
}
