package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void testOverdraftApproval(){
        Bank bank = new Bank();
        bank.getAccounts().add(new CurrentAccount(0,new Branch("xxx","xx")));
        bank.getAccounts().add(new SavingAccount(0,new Branch("xxx","xx")));

        Assertions.assertEquals("Approved", bank.overdraftApproval(bank.getAccounts().get(0)));
        Assertions.assertEquals("Rejected", bank.overdraftApproval(bank.getAccounts().get(1)));
    }

}
