package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAccount {
    @Test
    public void testSetBalance(){
        //because setBalance is private, i test the setBalance using the Account class
        Balance balance = new Balance(10,0);
        Account account = new Account(balance);
        Assertions.assertEquals(balance,account.getBalance());
        Assertions.assertEquals("10,0",account.getBalance().toString());
        Balance faultyBalance = new Balance(1,0);
        Balance anotherFaultyBalance = new Balance(-1,0);
        Account anotherAccount = new Account(faultyBalance);
        Account andAnotherAccount = new Account(anotherFaultyBalance);
        //on the 2 accounts above, their balance will not get initialized. This results in faulty accounts that can't be used.
        //this can be seen by messages in the terminal.

    }
}
