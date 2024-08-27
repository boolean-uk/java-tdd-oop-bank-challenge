package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void newCustomerTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein", 1, bank);
        bank.newCustomer(customer1);
        Assertions.assertTrue(bank.newCustomer(new Customer("Haakon", 2, bank)));
        Assertions.assertFalse(bank.newCustomer(new Customer("Haakon", 2, bank)));
    }

    @Test
    public void newAccountTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1, bank);
        bank.newCustomer(customer1);
        bank.newAccount(customer1, "Saving");
        bank.newAccount(customer1, "Current");

        for (Account a: customer1.getAccounts()){
            System.out.println(a.toString());
        }
    }

    @Test
    public void newTransactionTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1, bank);
        bank.newCustomer(customer1);

    }

    @Test
    public void reviewOverdraftRequests(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1, bank);
        bank.newCustomer(customer1);
        SavingsAccount savings1 = ((SavingsAccount) bank.newAccount(customer1, "Saving"));
        CurrentAccount current1 = ((CurrentAccount) bank.newAccount(customer1, "Current"));
        bank.newAccount(customer1, "Current");
        //SavingsAccount savings1 = customer1.getSavingsAccount();


        savings1.requestOverdraft(5000.00);
        current1.requestOverdraft(5000.00);

        bank.reviewOverdrafts();

        //customer1.requestOverdraft(int accountID,  )
    }

}
