package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    @Test
    public void testBranchConstructor() {
        Branch branch = new Branch("1", "DNC", "London");
        Assertions.assertEquals("1", branch.getBranchId());
        Assertions.assertEquals("DNC", branch.getName());
        Assertions.assertEquals("London", branch.getLocation());
    }
}