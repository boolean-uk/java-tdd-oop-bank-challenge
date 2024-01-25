package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    Bank bank = new Bank();

    @Test
    public void testAddAccount() {
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);
        Assertions.assertEquals("968736857", jonSnowAccountNr);



    }

}
