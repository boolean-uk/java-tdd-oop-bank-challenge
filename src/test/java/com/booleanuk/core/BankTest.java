package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void testAddAccount() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);
        Assertions.assertEquals("968736857", jonSnowAccountNr);
    }

    @Test
    public void testCheckAccountDetails() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);

        Account jonSnowAccount = bank.getAccount(jonSnowAccountNr);

        Assertions.assertEquals("Winterfell", jonSnowAccount.getBranch());
        Assertions.assertEquals(23.54, jonSnowAccount.getBalance());
        Assertions.assertEquals("Current Account", jonSnowAccount.getType());

    }

}
