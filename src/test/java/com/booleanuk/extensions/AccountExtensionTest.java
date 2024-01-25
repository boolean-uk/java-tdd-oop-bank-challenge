package com.booleanuk.extensions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountExtensionTest {
    @Test
    public void checkIfAccountIsConnectedToBranch() {
        Bank bank = new Bank();

        Branch southNorway = new Branch(234567, "South Norway");
        Branch eastNorway = new Branch(123456, "East Norway");

        bank.openCurrentAccount(southNorway);
        bank.openSavingsAccount(eastNorway);

        Account account = bank.getAccounts().get(0);
        Account account2 = bank.getAccounts().get(1);

        Assertions.assertEquals("South Norway", account.getBranch().getBranchName());

        Assertions.assertEquals("East Norway", account2.getBranch().getBranchName());
    }
}
