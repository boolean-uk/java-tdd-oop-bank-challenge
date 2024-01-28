package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BranchTest {
    Manager m = new Manager("Nicolai", 1992);
    Customer c = new Customer("Pia", 1996);
    Bank b = new Branch("Fredericia Afdeling", "Fredericia", 1, m);

    @Test
    public void testBranchClass() {
        Assertions.assertEquals("Fredericia Afdeling", b.getName());
        Assertions.assertEquals("Fredericia", b.getLocation());
        Assertions.assertEquals(1, b.getBranchID());
        Assertions.assertInstanceOf(Manager.class, b.getManager());
    }


}
