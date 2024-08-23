package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void newCustomerTest(){
        Bank bank = new Bank();
        bank.newCustomer("Jostein");
        Assertions.assertTrue(bank.newCustomer("Haakon"));
        Assertions.assertFalse(bank.newCustomer("Jostein"));
    }

    @Test
    public void newAccountTest(){
        Bank bank = new Bank();
        bank.newCustomer("Jostein");
        bank.newAccount("Jostein");
    }
}
