package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    public void getBranchWhichExists() {
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
}
