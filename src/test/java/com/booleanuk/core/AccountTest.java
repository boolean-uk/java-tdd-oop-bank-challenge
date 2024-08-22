package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testCreateAccount() {
        Account savings = new SavingsAccount(0, "Company");
        assertEquals(0, savings.getId());

        Account current = new CurrentAccount(1, "Private");
        assertEquals(1, current.getId());
    }
}
