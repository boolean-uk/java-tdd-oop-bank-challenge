package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    Bank bank;

    @Test
    public void testBankCreate() {
        bank = new Bank();
        assertEquals(0, bank.getIdCounter());

    }
}
