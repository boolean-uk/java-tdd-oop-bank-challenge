package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
@Test
    public void testBankBranches(){
        Bank bank = new Bank("Sparebanken Sør 25");
        bank.createUser("John", "John@example.org");
        bank.createUser("Timmy", "Timmy@example.org");
        Assertions.assertEquals(2, bank.getUsers().size());
        Assertions.assertEquals("Sparebanken Sør 25", bank.getUser(1).getBankBranch());
    }
}

