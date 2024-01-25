package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentAccountTest {
    @Test
    public void testSetLimit(){
        CurrentAccount account = new CurrentAccount();

        //negative number
        Assertions.assertFalse(account.setOverDraftLimit(-100));

        //positive number
        Assertions.assertTrue( account.setOverDraftLimit(100));

    }

    @Test
    public void testAddWithLimit(){
        CurrentAccount account = new CurrentAccount();

        Assertions.assertFalse(account.remove(50));

        account.setOverDraftLimit(100);

        Assertions.assertTrue(account.remove(50));

    }
}