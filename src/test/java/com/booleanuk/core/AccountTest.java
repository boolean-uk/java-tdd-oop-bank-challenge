package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testCreateAccount() {
        Account savings = new SavingsAccount(0, "Company");
        assertEquals(0, savings.getId());

        Account current = new CurrentAccount(1, "Private");
        assertEquals(1, current.getId());

        assertEquals(0, current.getInterest());

        assertEquals(5, savings.getInterest());
    }

    @Test
    public void testDepositAndWithdraw() {
        Account savings = new SavingsAccount(0, "Company");
        assertTrue(savings.deposit(500));
        assertEquals(500, savings.calcCurrentAmount());
        assertTrue(savings.deposit(5000));
        assertEquals(5500, savings.calcCurrentAmount());

    }
}
