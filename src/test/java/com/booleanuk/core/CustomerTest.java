package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    Manager m = new Manager("Nicolai", 1992);
    Customer c = new Customer("Pia", 1996);
    Branch b = new Branch("Fredericia Afdeling", "Fredericia", 1, m);

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

    @Test
    public void testCreateSavingsAccount() {
        Assertions.assertTrue(c.createSavingsAccount(b));
        Assertions.assertTrue(b.getSavingsAccounts().containsKey(33004782));
        Assertions.assertEquals(c, b.getSavingsAccounts().get(33004782).getAccountOwner());
        Assertions.assertNotEquals(m, b.getSavingsAccounts().get(33004782).getAccountOwner());

        Assertions.assertTrue(m.createSavingsAccount(b));
        Assertions.assertTrue(b.getSavingsAccounts().containsKey(69477450));
        Assertions.assertEquals(m, b.getSavingsAccounts().get(69477450).getAccountOwner());
        Assertions.assertNotEquals(c, b.getSavingsAccounts().get(69477450).getAccountOwner());

        Assertions.assertNotSame(b.getSavingsAccounts().get(33004782), b.getSavingsAccounts().get(69477450));
        System.out.println();
    }

    @Test
    public void testDeposit() {
        c.createCurrentAccount(b);
        m.createCurrentAccount(b);

        Assertions.assertEquals(0, b.getCurrentAccounts().get(33004782).getBalance());
        Assertions.assertTrue(c.deposit(b,33004782, 10));
        Assertions.assertEquals(10.0, b.getCurrentAccounts().get(33004782).getBalance());
        Assertions.assertFalse(m.deposit(b, 33004782, 10));
        Assertions.assertFalse(m.deposit(b, 110, 10));

        c.createSavingsAccount(b);
        Assertions.assertTrue(c.deposit(b, 27624789, 10));
        Assertions.assertEquals(b.getSavingsAccounts().get(27624789).getBalance(), b.getCurrentAccounts().get(33004782).getBalance());
    }

    @Test
    public void testWithdraw() {
        c.createCurrentAccount(b);
        m.createCurrentAccount(b);

        Assertions.assertEquals(0, b.getCurrentAccounts().get(33004782).getBalance());
        Assertions.assertFalse(c.withdraw(b, 33004782, 10));
        System.out.println(b.getCurrentAccounts().get(33004782).getBalance());
        Assertions.assertTrue(c.deposit(b, 33004782, 20));
        Assertions.assertFalse(c.withdraw(b, 33004782, 20));
        Assertions.assertTrue(c.withdraw(b, 33004782, 10));
        Assertions.assertEquals(10.0, b.getCurrentAccounts().get(33004782).getBalance());
        Assertions.assertFalse(m.withdraw(b, 33004782, 10));
        Assertions.assertFalse(m.withdraw(b, 110, 10));

        c.deposit(b, 33004782, 10);
        Assertions.assertTrue(c.withdraw(b, 33004782, 10));

        c.createSavingsAccount(b);
        Assertions.assertTrue(c.deposit(b, 27624789, 10));
        Assertions.assertFalse(c.withdraw(b, 27624789, 10));
        Assertions.assertEquals(b.getSavingsAccounts().get(27624789).getBalance(), b.getCurrentAccounts().get(33004782).getBalance());
    }

}
