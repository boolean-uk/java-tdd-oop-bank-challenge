package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class SavingsAccountTest {
    @Test
    public void testCreatingSavingsAccount() {
        Bank bank = new Bank();
        UUID customerId = bank.registerCustomer();

        Assertions.assertNotNull(bank.openAccount(customerId, SavingsAccount.class));
    }
}
