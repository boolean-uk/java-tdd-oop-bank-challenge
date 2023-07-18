package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BranchTest {

    @Test
    public void createBranch() {
        Branch branch = new Branch(
                "Warsaw",
                "WRS",
                30000
        );

        assertEquals(
                "Warsaw",
                branch.city()
        );
        assertEquals(
                "WRS",
                branch.code()
        );
        assertEquals(
                30000,
                branch.overdraftLimit()
        );
    }
}
