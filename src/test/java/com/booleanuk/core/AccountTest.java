package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void newTransactionTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1);
        bank.newCustomer(customer1);
        bank.newAccount(customer1, "Saving");
        SavingsAccount savings1 = customer1.getSavingsAccount();
        double newBalance = bank.newTransaction(savings1, 1000, 0);
        newBalance = bank.newTransaction(savings1, 500, 0);

        /*
        double newBalance = customer1.getSavingsAccount().newTransaction(1000, 0);
        newBalance = customer1.getSavingsAccount().newTransaction(3000, 0);
        newBalance = customer1.getSavingsAccount().newTransaction(1000, 5000);

         */

        Assertions.assertEquals(1500, customer1.getSavingsAccount().getBalance());

    }


    @Test
    public void generateAccountStatementTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1);
        bank.newCustomer(customer1);
        bank.newAccount(customer1, "Saving");
        SavingsAccount savings1 = customer1.getSavingsAccount();
        double newBalance = bank.newTransaction(savings1, 1000, 0);
        newBalance = bank.newTransaction(savings1, 1000, 0);
        newBalance = bank.newTransaction(savings1, 1000, 0);
        newBalance = bank.newTransaction(savings1, 1000, 500);
        System.out.println(newBalance);
        savings1.generateAccountStatement();

        //double newBalance = customer1.getSavingsAccount().newTransaction(1000, 0);
        //customer1.getSavingsAccount().generateAccountStatement();

    }
}
