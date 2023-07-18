package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BranchTest {
    Branch branch;

    @BeforeEach
    public void setup() {
        branch = new Branch("PLWAW1", "Poland", "Warsaw");
    }

    @Test
    public void branchGetterAndSetterShouldReturnProperValue() {
        Assertions.assertEquals("PLWAW1", branch.getCode());
        Assertions.assertEquals("Poland", branch.getCountry());
        Assertions.assertEquals("Warsaw", branch.getCity());

        branch.setCode("PLBIA23");
        branch.setCity("Bialystok");

        Assertions.assertEquals("PLBIA23", branch.getCode());
        Assertions.assertEquals("Poland", branch.getCountry());
        Assertions.assertEquals("Bialystok", branch.getCity());
    }

}
