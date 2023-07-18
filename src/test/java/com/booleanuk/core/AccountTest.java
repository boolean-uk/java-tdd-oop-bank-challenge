package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Branch branch;
    private Account account;

    @BeforeEach
    public void setup() {
        branch = new Branch("PLWAW1", "Poland", "Warsaw");
        account = new Account("12", branch);

    }

    @Test
    public void accountGetterAndSetterShouldReturnProperValue() {
        Assertions.assertEquals("12", account.getAccountNr());
    }
}
