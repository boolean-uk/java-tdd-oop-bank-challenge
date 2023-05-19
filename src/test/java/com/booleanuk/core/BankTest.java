package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void testBankIsCreated(){
        Bank bank = new Bank();
        Assertions.assertEquals(0, bank.getCustomers().size());
        Assertions.assertEquals(0, bank.getAccounts().size());
    }
}
