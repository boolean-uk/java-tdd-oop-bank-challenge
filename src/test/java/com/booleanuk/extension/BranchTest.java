package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BranchTest {
    @Test
    public void gettersAndSettersTest() {
        Branch branch = new Branch("PLWarsaw", "Poland, Warsaw");
        Assertions.assertEquals("PLWarsaw", branch.getId());
        Assertions.assertEquals("Poland, Warsaw", branch.getAddress());
    }
}
