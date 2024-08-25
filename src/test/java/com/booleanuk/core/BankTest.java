package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankTest {
    @Test
    public void testCreateCurrentAccount(){
        Bank bank = new Bank();
        Customer customer = new Customer("Program","prg@email.com","Prg Road 5",1);

        Assertions.assertEquals(bank.createAcc(customer,1),customer.getAccounts().get(0));
    }

    @Test
    public void testCreateSavingAccount(){
        Bank bank = new Bank();
        Customer customer = new Customer("Program2","prg@email.com","Prg Road 5",2);

        Assertions.assertEquals(bank.createAcc(customer,2),customer.getAccounts().get(0));
    }

    @Test
    public void testSeeTransactions(){
        Bank bank = new Bank();
        Customer customer = new Customer("Program2","prg@email.com","Prg Road 5",2);
        bank.createAcc(customer,1);
        bank.makeDeposit(customer,1,500);

        //Tested in main (Bank class)
        //Assertions.assertEquals("",bank.seeTransactions(customer,1));
    }

    @Test
    public void testTransactions(){
        Bank bank = new Bank();
        Customer customer = new Customer("Program2","prg@email.com","Prg Road 5",2);
        bank.createAcc(customer,1);
        Assertions.assertEquals("Added: 500.0 to balance in account: 1. New balance is now: 500.0",bank.makeDeposit(customer,1,500));

        Assertions.assertEquals("Withdrew 250.0 from balance in account: 1. New balance is now: 250.0",bank.makeWithdraw(customer,1,250));
    }


}
