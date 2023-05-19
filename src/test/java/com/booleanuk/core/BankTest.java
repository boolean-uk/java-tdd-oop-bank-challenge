package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void testAddAccountToTheBank(){
        Bank bank = new Bank();
        bank.getAccounts().add(new CurrentCount(12.00));
        bank.getAccounts().add(new SavingAccount(10.00));

        Assertions.assertEquals(2,bank.getAccounts().size());
    }
}
