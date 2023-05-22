package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBranch {
    @Test
    public void testConstructor(){
        Branch branch = new Branch(1); // first branch of the branchlist
        Assertions.assertEquals(100,branch.getNumberOfEmployees());
        Assertions.assertEquals("Main St. 12, Athens",branch.getAddress());
        Branch branch2 = new Branch(2);
        Assertions.assertEquals(80,branch2.getNumberOfEmployees());
        Assertions.assertEquals("Notsomain St. 40, Thessaloniki",branch2.getAddress());
    }
}
