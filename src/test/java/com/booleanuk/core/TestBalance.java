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
        Assertions.assertEquals("44.22",newBalance.toString());
    }
}
