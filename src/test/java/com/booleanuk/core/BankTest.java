package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    private boolean addCustomer;
    @Test
    public void newCustomerIsAddedTest(){
//        int id = 0;
        Bank bank = new Bank();
        Customer customer1 = new Customer(1);
        Customer customer2 = new Customer(2);
        Customer customer3 = new Customer(3);
        bank.addCustomer(customer1.id);
        Assertions.assertTrue(bank.addCustomer(customer3.id));
        Assertions.assertFalse(bank.getCustomers().contains(customer3.id));
    }

    @Test
    public void newAccountIsAddedTest() {
        // same for Savings and Checkings
        Bank bank = new Bank ();
        Account account1 = new Account("1111", 100, "Savings");
        Account account2 = new Account("2222", 200, "Savings");
        Account account3 = new Account("3333", 300, "Savings");
        bank.addAccount("2222", 200, "Savings");
        Assertions.assertTrue(bank.addAccount("4444", 400, "Checking"));
        Assertions.assertFalse(bank.addAccount("2222", 200, "Savings"));
    }

//    @Test
//    public void accountIdAlreadyExistsTest() {
//        Bank bank = new Bank();
//        Account account1 = new Account("1111", 100, "Savings");
//        bank.addAccount("1111", 100, "Savings");
//        Assertions.assertEquals("1111", bank.getAccounts().contains(account1));
//        Assertions.assertTrue(bank.getAccounts().contains(account1));
//    }

}