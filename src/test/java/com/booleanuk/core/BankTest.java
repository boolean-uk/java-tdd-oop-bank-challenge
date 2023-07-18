package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void isBankCreated(){
        Bank bank = new Bank();
        Assertions.assertTrue(bank.getCustomers().isEmpty());
        Assertions.assertTrue(bank.getAccounts().isEmpty());
    }
}
