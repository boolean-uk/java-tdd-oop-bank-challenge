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
        Account current = new CurrentAccount(0, "Company");
        assertTrue(current.deposit(500));
        assertEquals(500, current.calcCurrentAmount());
        assertTrue(current.deposit(5000));
        assertEquals(5500, current.calcCurrentAmount());

        current.withdraw(4000);
        assertEquals(1500, current.calcCurrentAmount());

    }
}
