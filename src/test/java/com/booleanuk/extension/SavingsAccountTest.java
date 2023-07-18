package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class SavingsAccountTest {
    @Test
    public void testCreatingSavingsAccount() {
        BankHQ hq = new BankHQ();
        BankBranch branch = hq.openBranch();
        UUID customerId = branch.registerCustomer();

        Assertions.assertNotNull(branch.openAccount(customerId, SavingsAccount.class));
    }
}
