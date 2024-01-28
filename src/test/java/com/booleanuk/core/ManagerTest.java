package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void testSetCreditScore() {
        Customer nicolai = new Customer("Nicolai", 999);
        Assertions.assertTrue(nicolai.getCreditScore() == CreditScore.FAIR);

        Manager dave = new Manager("Dave", 888);
        Assertions.assertTrue(dave.setCreditScore(nicolai, CreditScore.EXCELLENT));
        Assertions.assertNotSame(nicolai.getCreditScore(), CreditScore.FAIR);
        Assertions.assertSame(nicolai.getCreditScore(), CreditScore.EXCELLENT);
    }

}
