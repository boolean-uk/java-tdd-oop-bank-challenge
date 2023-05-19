package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAccountActions {
    @Test
    public void testCreateCurrentAccount() {
        AccountActions accountAction = new AccountActions();

        //Test for successful creation of account
        Assertions.assertTrue(accountAction.createAccount("NDBK-0000-0001", "Aidan", "van Geest", "ROT001"));

        //Test for failed creation of account
        Assertions.assertFalse(accountAction.createAccount("NDBK-0000-0001", "Aidan", "van Geest", "ROT001"));
    }



}
