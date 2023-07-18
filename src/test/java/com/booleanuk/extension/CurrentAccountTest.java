package com.booleanuk.extension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CurrentAccountTest {
    private CurrentAccount account;

    @BeforeEach
    public void setUp() {
        Branch branch = new Branch("Bank Branch Warszawa-Srodmiescie", "Nowy Swiat 22/11, 01-412 Warszawa");
        account = new CurrentAccount(branch);
    }

    @Test
    void requestOverdraftRequestsOverdraft() {
        account.requestOverdraft();

        assertTrue(account.isOverdraftRequested());
    }
}