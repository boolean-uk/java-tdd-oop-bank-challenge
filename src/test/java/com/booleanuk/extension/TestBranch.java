package com.booleanuk.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestBranch {
    @Test
    void testNewCurrentAccount() {
        Bank bank = new Bank();
        Branch branch = bank.newBranch();

        CurrentAccount acc = branch.newCurrentAccount();

        Assertions.assertEquals(1, branch.getAccounts().size());
        Assertions.assertEquals(100010000000L, acc.getAccountNr());
    }

    @Test
    void testNewSavingsAccount() {
        Bank bank = new Bank();
        Branch branch = bank.newBranch();

        SavingsAccount acc = branch.newSavingsAccount();

        Assertions.assertEquals(1, branch.getAccounts().size());
        Assertions.assertEquals(100010000000L, acc.getAccountNr());
    }
}
