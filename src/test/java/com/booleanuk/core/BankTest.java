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
        Account a1 = bank.newAccount(customer1, "Saving");
        Account a2 = bank.newAccount(customer1, "Current");

        Assertions.assertNotNull(a1);
        Assertions.assertNotNull(a2);
    }


    @Test
    public void reviewOverdraftRequests(){
        //Cannot test this one as it relies on user input
    }

}
