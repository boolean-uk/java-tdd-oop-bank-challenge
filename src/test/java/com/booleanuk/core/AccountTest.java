package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void newTransactionTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1, bank);
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
        Customer customer1 = new Customer("Jostein",1, bank);
        bank.newCustomer(customer1);
        bank.newAccount(customer1, "Saving");
        SavingsAccount savings1 = customer1.getSavingsAccount();
        double newBalance = bank.newTransaction(savings1, 1000, 0);
        newBalance = bank.newTransaction(savings1, 1000, 0);
        newBalance = bank.newTransaction(savings1, 1000, 0);
        newBalance = bank.newTransaction(savings1, 1000, 5000);
        System.out.println(newBalance);
        savings1.generateAccountStatement();

        //double newBalance = customer1.getSavingsAccount().newTransaction(1000, 0);
        //customer1.getSavingsAccount().generateAccountStatement();
    }

    @Test
    public void overDraftWithdrawTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1, bank);
        bank.newCustomer(customer1);
        bank.newAccount(customer1, "Saving");
        SavingsAccount savings1 = customer1.getSavingsAccount();
        savings1.setOverdraftAmount(1000.00);

        double newBalance = bank.newTransaction(savings1, 2000, 0);
        newBalance = bank.newTransaction(savings1, 0, 1000);
        newBalance = bank.newTransaction(savings1, 0, 1000);
        newBalance = bank.newTransaction(savings1, 0, 1000);
        newBalance = bank.newTransaction(savings1, 0, 1000); // newBalance if overdraft successful = -2000

        savings1.generateAccountStatement();
        Assertions.assertEquals(-1000, newBalance);
    }

    @Test
    public void requestOverdraftTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1, bank);
        bank.newCustomer(customer1);
        SavingsAccount savings1 = ((SavingsAccount) bank.newAccount(customer1, "Saving"));
        CurrentAccount current1 = ((CurrentAccount) bank.newAccount(customer1, "Current"));
        bank.newAccount(customer1, "Current");
        //SavingsAccount savings1 = customer1.getSavingsAccount();


        savings1.requestOverdraft(5000.00);
        current1.requestOverdraft(5000.00);

        //customer1.requestOverdraft(int accountID,  )
    }
}
