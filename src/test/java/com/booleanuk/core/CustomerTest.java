package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    Manager m = new Manager("Nicolai", 1992);
    Customer c = new Customer("Pia", 1996);
    Branch b = new Branch("Fredericia Afdeling", "Fredericia", 1, m);
    Account s = new SavingsAccount(b, 9999, m, 0.0);
    Account cur = new CurrentAccount(b, 6666, c, 10.0);

    @Test
    public void testCreateCurrentAccount() {
        Assertions.assertTrue(c.createCurrentAccount(b));
        Assertions.assertTrue(b.getCurrentAccounts().containsKey(33004782));
        Assertions.assertEquals(c, b.getCurrentAccounts().get(33004782).getAccountOwner());
        Assertions.assertNotEquals(m, b.getCurrentAccounts().get(33004782).getAccountOwner());

        Assertions.assertTrue(m.createCurrentAccount(b));
        Assertions.assertTrue(b.getCurrentAccounts().containsKey(69477450));
        Assertions.assertEquals(m, b.getCurrentAccounts().get(69477450).getAccountOwner());
        Assertions.assertNotEquals(c, b.getCurrentAccounts().get(69477450).getAccountOwner());

        Assertions.assertNotSame(b.getCurrentAccounts().get(33004782), b.getCurrentAccounts().get(69477450));
        System.out.println();
    }
}
