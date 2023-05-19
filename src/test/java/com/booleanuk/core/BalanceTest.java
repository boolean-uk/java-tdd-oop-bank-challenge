package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BalanceTest {
    @Test
    public void testGetBalance(){
        Balance balance = new Balance(22,44);
        Assertions.assertEquals(22,balance.getIntPart());
    }
}
