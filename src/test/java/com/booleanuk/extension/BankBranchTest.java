package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankBranchTest {

    BankBranch branch;

    @BeforeEach
    void setUp() {
        branch = new BankBranch();
    }

    @Test
    void shouldIncreaseNumberOfAccounts() {
        Account account = new CurrentAccount();
        branch.add(account);
        Assertions.assertEquals(1, branch.getAccounts().size());
        branch.add(account);
        Assertions.assertEquals(1, branch.getAccounts().size());
    }
}
