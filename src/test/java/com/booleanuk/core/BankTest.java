package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void testAddingAccountToBranch() {
        Bank bank = new Bank();

        Account norCur = bank.createAccount("NORWAY", "CURRENT");
        Account ukCur = bank.createAccount("UK", "CURRENT");
        Account seCur = bank.createAccount("SWEDEN", "CURRENT");
        Account norSave = bank.createAccount("NORWAY", "SAVING");

        norCur.deposit(500);
        norSave.deposit(1500);
        ukCur.deposit(20);
        seCur.deposit(10000);

        Assertions.assertEquals(2, bank.getNORWAY().size());
        Assertions.assertEquals(1, bank.getUK().size());
        Assertions.assertEquals(1, bank.getSWEDEN().size());

        Assertions.assertEquals(500, bank.getNORWAY().get(0).calculateBalance());
        Assertions.assertEquals(1500, bank.getNORWAY().get(1).calculateBalance());
        Assertions.assertEquals(20, bank.getUK().get(0).calculateBalance());
        Assertions.assertEquals(10000, bank.getSWEDEN().get(0).calculateBalance());
    }
}
