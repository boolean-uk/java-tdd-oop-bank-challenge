package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BranchTest {

    @Test
    public void testBranch(){
        Branch branch = new Branch("Oslo Branch");

        Assertions.assertEquals("Oslo Branch", branch.getName());
    }
}
