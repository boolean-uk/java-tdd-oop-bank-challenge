package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @BeforeEach
    static void setup() {
        Branch branch = new Branch("PLWAW1", "Poland", "Warsaw");
        Account account = new Account(12);
    }

    @Test
    public void accountGetterAndSetterShouldReturnProperValue() {
        Assertions.assertEquals(12, account.getAccountNr());
    }
}
