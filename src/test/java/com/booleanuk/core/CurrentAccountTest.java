package com.booleanuk.core;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrentAccountTest {

    @Test
    public void testApplyOverdraft() {
        CurrentAccount currentAccount = new CurrentAccount(500);
        currentAccount.applyOverdraft();
        assertEquals(-500.0, currentAccount.getBalance());
    }

    @Test
    public void testCheckOverdraft() {
        CurrentAccount currentAccount = new CurrentAccount(500);
        assertFalse(currentAccount.checkOverdraft());
        currentAccount.applyOverdraft();
        assertTrue(currentAccount.checkOverdraft());
    }
}

