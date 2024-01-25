package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    Manager m = new Manager("Nicolai", 1992);
    Customer c = new Customer("Pia", 1996);
    Branch b = new Branch("Fredericia Afdeling", "Fredericia", 1, m);
    Account s = new SavingsAccount(b, 9999, m, 0.0);
    Account cur = new CurrentAccount(b, 6666, c, 10.0);

    @Test
    public void testSavingsAccount() {
        Assertions.assertInstanceOf(SavingsAccount.class, s);
        Assertions.assertEquals(b, s.getBranch());
        Assertions.assertEquals(9999, s.getAccountNumber());
        Assertions.assertEquals(m, s.getAccountOwner());
        Assertions.assertEquals(0.0, s.getBalance());
        Assertions.assertTrue(s.getTransactionHistory().isEmpty());
    }

    @Test
    public void testCurrentAccount() {
        Assertions.assertInstanceOf(CurrentAccount.class, cur);
        Assertions.assertEquals(b, cur.getBranch());
        Assertions.assertEquals(6666, cur.getAccountNumber());
        Assertions.assertEquals(c, cur.getAccountOwner());
        Assertions.assertEquals(10.0, cur.getBalance());
        Assertions.assertTrue(cur.getTransactionHistory().isEmpty());
    }
}
