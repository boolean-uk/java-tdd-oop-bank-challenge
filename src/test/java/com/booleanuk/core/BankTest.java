package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void newCustomerTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein", 1);
        bank.newCustomer(customer1);
        Assertions.assertTrue(bank.newCustomer(new Customer("Haakon", 2)));
        Assertions.assertFalse(bank.newCustomer(new Customer("Haakon", 2)));
    }

    @Test
    public void newAccountTest(){
        Bank bank = new Bank("Oslo");
        Customer customer1 = new Customer("Jostein",1);
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
        Customer customer1 = new Customer("Jostein",1);
        bank.newCustomer(customer1);
    }

}
