package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void createSavingsAccountTest(){
        Bank bank = new Bank();
        Assertions.assertEquals(1,bank.openSavingsAccount("Jan Lisek"));
        Assertions.assertEquals("Jan Lisek", bank.getSavingsAccounts().get(0).getAccountOwner());
    }

    @Test
    public void createCurrentAccountTest(){
        Bank bank = new Bank();
        Assertions.assertEquals(1,bank.openCurrentAccount("Jan Lisek"));
        Assertions.assertEquals("Jan Lisek", bank.getCurrentAccounts().get(0).getAccountOwner());
    }
}
