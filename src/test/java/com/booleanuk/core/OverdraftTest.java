package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OverdraftTest {

    @Test
    public void init() {
        Overdraft overdraft = new Overdraft(500.00);
    }


    @Test
    public void settersValid() {
        Overdraft overdraft = new Overdraft(500.00);
        Overdraft overdraft2 = new Overdraft(-500.00);

        Assertions.assertEquals(500, overdraft.getAmount());
        Assertions.assertFalse(overdraft.setAmount(-100));
        Assertions.assertTrue(overdraft.setAmount(100));
        Assertions.assertEquals(100, overdraft.getAmount());
        Assertions.assertFalse(overdraft.isApproved());
        Assertions.assertTrue(overdraft.setApproved(false));
        Assertions.assertFalse(overdraft.isApproved());


        Assertions.assertEquals(0, overdraft2.getAmount());
    }
}
