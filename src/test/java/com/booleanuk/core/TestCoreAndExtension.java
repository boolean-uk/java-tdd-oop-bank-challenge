package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestCoreAndExtension {

    @Test
    public void testDeposit(){
        Customer customer1 = new Customer("customer1");
        Assertions.assertTrue(customer1.getCurrent().getTransactions().isEmpty());
        Assertions.assertEquals(500, customer1.getCurrent().deposit(500).getCredit());
        Assertions.assertEquals(LocalDate.now(), customer1.getCurrent().deposit(100).getDate());
        Assertions.assertEquals(2, customer1.getCurrent().getTransactions().size());
        for(Transaction t : customer1.getCurrent().getTransactions()){
            System.out.println(t.getDate() + " " + t.getCredit());
        }
    }

    @Test
    public void testWithdraw(){
        Customer customer1 = new Customer("customer1");
        Current current = customer1.getCurrent();
        Assertions.assertTrue(current.getTransactions().isEmpty());
        Transaction transaction = current.withdraw(225);
        Assertions.assertEquals(1, current.getTransactions().size());
        Assertions.assertEquals(0, transaction.getCredit());
        Assertions.assertEquals(225, transaction.getDebit());
        Assertions.assertEquals(LocalDate.now(), transaction.getDate());
    }

    @Test
    public void testGetBalance(){
        Customer customer1 = new Customer("customer1");
        Current current = customer1.getCurrent();
        Assertions.assertEquals(0, current.getBalance());
        current.deposit(500);
        Assertions.assertEquals(500, current.getBalance());
        current.deposit(300);
        Assertions.assertEquals(800, current.getBalance());
        current.withdraw(50);
        Assertions.assertEquals(750, current.getBalance());
    }

    @Test
    public void testStatement(){
        Customer customer1 = new Customer("customer1");
        Current current = customer1.getCurrent();
        current.deposit(500);
        current.deposit(300);
        current.withdraw(50);
        Assertions.assertEquals("date       || credit  || debit  || balance\n" +
                        LocalDate.now() + " || 500     ||        || 500\n" +
                        LocalDate.now() + " || 300     ||        || 800\n" +
                        LocalDate.now() + " ||         || 50     || 750", current.statement());
    }

    @Test
    public void testToggleOverdraft(){
        Customer customer1 = new Customer("customer1");
        Current current = customer1.getCurrent();
        Assertions.assertFalse(current.getOverdraft());
        current.toggleOverdraft();
        Assertions.assertTrue(current.getOverdraft());
    }

    @Test
    public void testOverdraft(){
        Customer customer1 = new Customer("customer1");
        Current current = customer1.getCurrent();
        current.withdraw(500);
        Assertions.assertEquals(0, current.getBalance());
        current.overdraft(500);
        Assertions.assertEquals(0, current.getBalance());
        current.toggleOverdraft();
        current.overdraft(500);
        Assertions.assertEquals(-500, current.getBalance());
    }

    @Test
    public void testOverdraftLimit(){
        Customer customer1 = new Customer("customer1");
        Current current = customer1.getCurrent();
        current.toggleOverdraft();
        current.overdraft(1001);
        Assertions.assertEquals(0, current.getBalance());
        current.overdraft(1000);
        Assertions.assertEquals(-1000, current.getBalance());
    }

    @Test
    public void testPrint(){
        Customer customer1 = new Customer("customer1");
        Current current = customer1.getCurrent();
        current.deposit(500);
        current.deposit(300);
        current.withdraw(50);
        System.out.println(current.statement());
    }




    /*@Test
    public void testAddAccount(){
        Customer customer1 = new Customer("customer1");
        Assertions.assertTrue(customer1.getAccounts().isEmpty());
        customer1.addAccount("current");
        customer1.addAccount("SAVINGS");
        customer1.addAccount("test");
        Assertions.assertFalse(customer1.getAccounts().isEmpty());
        Assertions.assertEquals(2, customer1.getAccounts().size());
    }*/

    /*@Test
    public void testFindingSpecificAccount(){
        Customer customer1 = new Customer("customer1");
        customer1.addAccount("current");
        customer1.addAccount("savings");
        Assertions.assertTrue(customer1.getAccounts().contains("current"));
    }*/

    /*
    @Test
    public void testDeposit(){
        Customer customer1 = new Customer("customer1");
        customer1.addAccount("current");
        Assertions.assertEquals(0, );
        Assertions.assertEquals(500, );
    }
    */

}
