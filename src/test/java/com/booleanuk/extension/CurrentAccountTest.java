package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CurrentAccountTest {
    @Test
    public void testCreatingCurrentAccount() {
        BankBranch bankBranch = (new BankHQ()).openBranch();
        UUID customerId = bankBranch.registerCustomer();

        Assertions.assertNotNull(bankBranch.openAccount(customerId, CurrentAccount.class));
    }
}