package com.booleanuk.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestBank {
    @Test
    void testNewBranch() {
        Bank bank = new Bank();

        Branch branch = bank.newBranch();
        Assertions.assertEquals(1000, branch.getId());
        Assertions.assertEquals(1, bank.getBranches().size()); // check if added to map

        branch = bank.newBranch();
        Assertions.assertEquals(1001, branch.getId());
        Assertions.assertEquals(2, bank.getBranches().size()); // check if added to map
    }
}
