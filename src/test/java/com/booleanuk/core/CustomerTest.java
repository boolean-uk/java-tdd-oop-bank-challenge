package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {


    @Test
    public void testCreateAccount(){
        Customer customer = new Customer();

        //Savings
        Assertions.assertTrue(customer.createAccount("Savings"));

        //Current
        Assertions.assertTrue(customer.createAccount("Current"));

        //Something else
        Assertions.assertFalse(customer.createAccount("Something else"));
    }

    @Test
    public void testDeposit(){
        Customer customer = new Customer();
        Account account = new SavingsAccount();

        //Positive Number
        Assertions.assertTrue(customer.deposit(account, 200));

        //Negative Number
        Assertions.assertFalse(customer.deposit(account, -200));
    }

    @Test
    public void testWithDraw(){
        Customer customer = new Customer();
        Account account = new SavingsAccount();

        customer.deposit(account, 100);

        //Larger than balance
        Assertions.assertFalse(customer.withdraw(account, 101));

        //Negative number
        Assertions.assertFalse(customer.withdraw(account, -1));

        //Less than balance
        Assertions.assertTrue(customer.withdraw(account, 10));

    }

    @Test
    public void testGenerateBankStatement(){
        Customer customer = new Customer();
        Account account = new SavingsAccount();

        customer.deposit(account, 100);

        customer.withdraw(account, 12);

        customer.withdraw(account, 7.5);

        System.out.println(customer.generateBankStatement(account));

    }


}