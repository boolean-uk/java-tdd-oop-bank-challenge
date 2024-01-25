package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    Person m = new Manager("Nicolai", 1992);
    Person c = new Customer("Pia", 1996);

    @Test
    public void testPersonClass() {
        Assertions.assertInstanceOf(Person.class, c);
        Assertions.assertInstanceOf(Customer.class, c);
        Assertions.assertInstanceOf(Person.class, m);
        Assertions.assertInstanceOf(Manager.class, m);
    }

    @Test
    public void testPersonMemberVariables() {
        Assertions.assertEquals(m.getName(), "Nicolai");
        Assertions.assertEquals(m.getUID(), 1992);
        Assertions.assertEquals(c.getName(), "Pia");
        Assertions.assertEquals(c.getUID(), 1996);
    }
}
