package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Bank bank;

    @Test
    public void testCreateAccount() {
        bank = new Bank();
        Account savings = new SavingsAccount(0, "Company");
        assertEquals(0, savings.getId());

        Account current = new CurrentAccount(1, "Private", bank);
        assertEquals(1, current.getId());

        assertEquals(0, current.getInterest());

        assertEquals(5, savings.getInterest());
    }

    @Test
    public void testDepositAndWithdraw() {
        bank = new Bank();
        Account current = new CurrentAccount(0, "Company", bank);
        assertTrue(current.deposit(500));
        assertEquals(500, current.calcCurrentAmount());
        assertTrue(current.deposit(5000));
        assertEquals(5500, current.calcCurrentAmount());

        assertTrue(current.withdraw(4000));
        assertEquals(1500, current.calcCurrentAmount());

        assertFalse(current.withdraw(3000));

    }
}
