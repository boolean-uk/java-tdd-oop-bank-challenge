package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCurrentAccount {
    @Test
    public void testOverdraft(){
        CurrentAccount account = new CurrentAccount();

        Assertions.assertFalse(account.withdraw(1000));
        Assertions.assertTrue(account.setOverdraft(1000));
        Assertions.assertTrue(account.withdraw(300));
        Assertions.assertTrue(account.withdraw(300));
        Assertions.assertFalse(account.withdraw(500));
    }
}
