package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void testcreateCurrentAccount(){
        Bank bank = new Bank();
        bank.createCurrentAccount("Brierley Hill");
        Assertions.assertEquals("Brierley Hill", bank.getAccountList().get(0).getBranch());
    }
    @Test
    public void testcreateSavingAccount(){
        Bank bank = new Bank();
        bank.createSavingsAccount("Brierley Hill");
        Assertions.assertEquals("Brierley Hill", bank.getAccountList().get(0).getBranch());
    }

}
