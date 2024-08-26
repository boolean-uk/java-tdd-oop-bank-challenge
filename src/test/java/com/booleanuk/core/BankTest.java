package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    public BankTest() {

    }

    @Test
    public void testCreateBank() {
        Bank bank = new Bank("Swedbank");

        Assertions.assertEquals("Swedbank", bank.getName());
    }

}
