package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void testCreateBankInstance() {
        Bank bank = new Bank("Name");
        Assertions.assertNotNull(bank);
    }
}
