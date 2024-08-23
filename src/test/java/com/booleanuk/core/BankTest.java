package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void newCustomerTest(){
        Bank bank = new Bank();
        bank.newCustomer("Jostein");

    }
}
