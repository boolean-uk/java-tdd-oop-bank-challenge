package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBalance {
    @Test
    public void testGetBalance(){
        Balance balance = new Balance(22,44);
        Assertions.assertEquals(22,balance.getIntPart());
        Balance newBalance = new Balance(44,22);
        Assertions.assertEquals(44,newBalance.getIntPart());
        Assertions.assertEquals(22,newBalance.getDecimalPart());
        Assertions.assertEquals("44,22",newBalance.toString());
    }
    @Test
    public void testInteract(){
        Balance test = new Balance(100,0);
        Balance toDeposit = new Balance(50,0);
        Balance toWithdraw = new Balance(-50,0);
        test.interact(toDeposit); // add 50,0 to the 100,0
        test.interact(toDeposit); // add another 50,0
        Assertions.assertEquals(200,test.getIntPart());
        test.interact(toWithdraw); // remove 50,0
        Assertions.assertEquals(150,test.getIntPart());
    }
}
