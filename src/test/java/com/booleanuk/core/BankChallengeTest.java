package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankChallengeTest {

    @Test
    public void createCurrentAccount() {
        CurrentAccount current1 = new CurrentAccount();
        CurrentAccount current2 = new CurrentAccount(10.0);

        Assertions.assertNotNull(current1);
        Assertions.assertNotNull(current2);

    }
    @Test
    public void currentAccountBalance() {
        CurrentAccount current1 = new CurrentAccount();
        CurrentAccount current2 = new CurrentAccount(10.0);
        CurrentAccount current3 = new CurrentAccount();

        current3.setBalance(100.0);

        Assertions.assertEquals(0.0, current1.getBalance());
        Assertions.assertEquals(10.0, current2.getBalance());
        Assertions.assertEquals(100.0, current3.getBalance());
    }


    @Test
    public void createSavingsAccount() {
        SavingsAccount savings1 = new SavingsAccount();
        SavingsAccount savings2 = new SavingsAccount(10.0);

        Assertions.assertNotNull(savings1);
        Assertions.assertNotNull(savings2);

    }
    @Test
    public void savingsAccountBalance() {
        SavingsAccount savings1 = new SavingsAccount();
        SavingsAccount savings2 = new SavingsAccount(10.0);
        SavingsAccount savings3 = new SavingsAccount();

        savings3.setBalance(100.0);

        Assertions.assertEquals(0.0, savings1.getBalance());
        Assertions.assertEquals(10.0, savings2.getBalance());
        Assertions.assertEquals(100.0, savings3.getBalance());
    }


    @Test
    public void generateStatements() {
        CurrentAccount current = new CurrentAccount(500.0);
        SavingsAccount savings = new SavingsAccount(10000.0);

        String currentRecords = current.getRecords();
        String savingsRecords = savings.getRecords();

        Assertions.assertNotNull(current);
        Assertions.assertNotNull(savings);

        Assertions.assertEquals("date       || credit  || debit  || balance\n" +
                "14/01/2012 ||         ||  || 500.00", currentRecords);
        Assertions.assertEquals("date       || credit  || debit  || balance\n" +
                "14/01/2012 ||         ||  || 500.00", savingsRecords);

    }
}
