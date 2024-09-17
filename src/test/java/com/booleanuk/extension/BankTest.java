package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BankTest {

    @Test
    public void getBranchThatExists() {
        Branch branch = Bank.getBranch("WCA");

        assertEquals(
                "Warsaw",
                branch.city()
        );
        assertEquals(
                400000,
                branch.overdraftLimit()
        );
    }

    @Test
    public void getBranchThatDoesNotExist() {
        Branch branch = Bank.getBranch("BGD");

        assertNull(branch);
    }
}
