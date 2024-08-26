package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    Manager m = new Manager("Nicolai", 1992);
    Customer c = new Customer("Pia", 1996);
    Branch b = new Branch("Fredericia Afdeling", "Fredericia", 1, m);

    @Test
    public void testRequestOverdraft() {
        c.createCurrentAccount(b);
        Assertions.assertFalse(c.requestOverdraft(b, 33004782, 5000));
        m.setCreditScore(c, CreditScore.EXCELLENT);
        Assertions.assertTrue(c.requestOverdraft(b, 33004782, 5000));
        c.deposit(b, 33004782, 750);
        c.deposit(b, 33004782, 500);
        c.withdraw(b, 33004782, 4000);
        c.generateBankStatement(b);
        System.out.println();
    }
}
