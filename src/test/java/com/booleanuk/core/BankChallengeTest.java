package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankChallengeTest {
    SimpleDateFormat formatting = new SimpleDateFormat("dd-MM-yyyy");


    @Test
    public void createCurrentAccount() {
        CurrentAccount current1 = new CurrentAccount();

        Assertions.assertNotNull(current1);

    }
    @Test
    public void currentAccountBalance() {
        CurrentAccount current1 = new CurrentAccount();
        CurrentAccount current2 = new CurrentAccount();
        CurrentAccount current3 = new CurrentAccount();

        current2.setBalance(10.0);
        current3.setBalance(100.0);

        Assertions.assertEquals(0.0, current1.getBalance());
        Assertions.assertEquals(10.0, current2.getBalance());
        Assertions.assertEquals(100.0, current3.getBalance());
    }


    @Test
    public void createSavingsAccount() {
        SavingsAccount savings1 = new SavingsAccount();
        SavingsAccount savings2 = new SavingsAccount();

        savings2.setBalance(10.0);

        Assertions.assertNotNull(savings1);
        Assertions.assertNotNull(savings2);

    }
    @Test
    public void savingsAccountBalance() {
        SavingsAccount savings1 = new SavingsAccount();
        SavingsAccount savings2 = new SavingsAccount();
        SavingsAccount savings3 = new SavingsAccount();

        savings2.setBalance(10.0);
        savings3.setBalance(100.0);

        Assertions.assertEquals(0.0, savings1.getBalance());
        Assertions.assertEquals(10.0, savings2.getBalance());
        Assertions.assertEquals(100.0, savings3.getBalance());
    }


    @Test
    public void testDepositing() throws ParseException {
        CurrentAccount current1 = new CurrentAccount();
        CurrentAccount current2 = new CurrentAccount();
        SavingsAccount savings1 = new SavingsAccount();
        SavingsAccount savings2 = new SavingsAccount();

        current1.deposit(100.0, formatting.parse("10-1-2024"));
        savings1.deposit(10000.0, formatting.parse("10-1-2024"));

        Assertions.assertEquals(100.0, current1.getBalance());
        Assertions.assertEquals(10000.0, savings1.getBalance());
        Assertions.assertFalse(current2.deposit(-100.0, formatting.parse("10-1-2024")));
        Assertions.assertFalse(savings2.deposit(-10000.0, formatting.parse("10-1-2024")));

    }
    @Test
    public void testWithdrawing() throws ParseException {
        CurrentAccount current1 = new CurrentAccount();
        current1.deposit(200.0, formatting.parse("10-1-2024"));
        CurrentAccount current2 = new CurrentAccount();
        current2.deposit(10.0, formatting.parse("10-1-2024"));

        SavingsAccount savings1 = new SavingsAccount();
        savings1.deposit(100000.0, formatting.parse("10-1-2024"));

        SavingsAccount savings2 = new SavingsAccount();
        savings2.deposit(1000.0, formatting.parse("10-1-2024"));

        SavingsAccount savings3 = new SavingsAccount();
        savings3.deposit(10000.0, formatting.parse("10-1-2024"));



        Assertions.assertTrue(current1.withdraw(100.0, formatting.parse("10-1-2024")));
        Assertions.assertFalse(current2.withdraw(100.0, formatting.parse("10-1-2024")));

        Assertions.assertTrue(savings1.withdraw(10000.0, formatting.parse("10-1-2024")));
        Assertions.assertFalse(savings2.withdraw(10000.0, formatting.parse("10-1-2024")));
        savings3.withdraw(10000.0, formatting.parse("10-1-2024"));
        Assertions.assertEquals(0.0, savings3.getBalance());

    }

    @Test
    public void testRecords() throws ParseException {
        CurrentAccount current = new CurrentAccount();
        SavingsAccount savings = new SavingsAccount();

        current.withdraw(10, formatting.parse("10-1-2024"));

        current.deposit(100, formatting.parse("11-1-2024"));
        current.deposit(1000, formatting.parse("12-1-2024"));

        current.deposit(10000, formatting.parse("13-1-2024"));
        current.withdraw(10000, formatting.parse("13-1-2024"));

        current.deposit(200, formatting.parse("14-1-2024"));
        current.withdraw(200000, formatting.parse("15-1-2024"));

        savings.withdraw(200000, formatting.parse("15-1-2024"));


        String currentRecords = current.getRecords();
        String savingsRecords = savings.getRecords();
        System.out.println(currentRecords);
        Assertions.assertNotNull(current);

        Assertions.assertTrue(currentRecords.length() > 50 );
        Assertions.assertFalse(savingsRecords.isEmpty());
    }

    @Test
    public void testEmptyRecords() throws ParseException {
        CurrentAccount current = new CurrentAccount();

        String currentRecords = current.getRecords();
        System.out.println(currentRecords);

        Assertions.assertFalse(currentRecords.isEmpty());

    }

    @Test
    public void testOverdraftRequestSwitching() {
        CurrentAccount current = new CurrentAccount();

        Assertions.assertFalse(current.getOverdraft());

        current.requestOverdraft();

        Assertions.assertTrue(current.getOverdraft());

        current.requestOverdraft();

        Assertions.assertFalse(current.getOverdraft());
    }
    @Test
    public void testRequestOverdraftWithdraw() throws ParseException {
        CurrentAccount current = new CurrentAccount();

        Assertions.assertFalse(current.withdraw(500, formatting.parse("10-1-2024")));
        current.requestOverdraft();
        Assertions.assertTrue(current.withdraw(500, formatting.parse("10-1-2024")));
    }

    @Test
    public void testBankManagerOverdraftRequest() throws ParseException {
        CurrentAccount current = new CurrentAccount();

        Assertions.assertFalse(current.withdraw(500, formatting.parse("10-1-2024")));
        current.requestOverdraft();
        Assertions.assertTrue(current.withdraw(500, formatting.parse("10-1-2024")));
        current.requestOverdraft();
        Assertions.assertFalse(current.withdraw(20000, formatting.parse("10-1-2024")));
    }

}
