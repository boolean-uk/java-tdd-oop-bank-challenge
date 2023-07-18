package com.booleanuk.extension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.booleanuk.extension.CurrentAccount.OVERDRAFT;
import static org.junit.jupiter.api.Assertions.*;

class CurrentAccountTest {
    private CurrentAccount account;

    @BeforeEach
    public void setUp() {
        Branch branch = new Branch("Bank Branch Warszawa-Srodmiescie", "Nowy Swiat 22/11, 01-412 Warszawa");
//        TwilioService twilioService = new TwilioService();
//        account = new CurrentAccount(branch, twilioService);
        account = new CurrentAccount(branch);
    }

    @Test
    void withdrawAllowsToWithdrawOverdraftWhenAllowed() {
        account.approveOverdraft();

        account.withdraw(OVERDRAFT);

        assertEquals(OVERDRAFT * -1, account.getBalance());
    }

    @Test
    void withdrawDoesNotAllowToWithdrawOverdraftWhenNotAllowed() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(OVERDRAFT));
    }

    @Test
    void requestOverdraftRequestsOverdraft() {
        account.requestOverdraft();

        assertTrue(account.isOverdraftRequested());
    }

    @Test
    void approveOverdraftRequestApprovesOverdraft() {
        account.approveOverdraft();

        assertTrue(account.isOverdraftAllowed());
        assertFalse(account.isOverdraftRequested());
    }

    @Test
    void rejectOverdraftRequestRejectsOverdraft() {
        account.rejectOverdraft();

        assertFalse(account.isOverdraftAllowed());
        assertFalse(account.isOverdraftRequested());
    }
}