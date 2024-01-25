package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankTest {
    @Test
    public void testCreateCurrentAccount(){
        Bank bank = new Bank();
        ArrayList<Account> emptyList = new ArrayList<>();
        Customer customer = new Customer("Program","prg@email.com","Prg Road 5",1,emptyList);
        bank.createAcc(customer,1);
        Assertions.assertEquals("",customer.getAccounts().get(0));
    }

    @Test
    public void testCreateSavingAccount(){
        Bank bank = new Bank();
        ArrayList<Account> emptyList = new ArrayList<>();
        Customer customer = new Customer("Program2","prg@email.com","Prg Road 5",2,emptyList);
        bank.createAcc(customer,2);
        Assertions.assertEquals("",customer.getAccounts().get(0));
    }

    @Test
    public void testSeeTransactions(){
        Bank bank = new Bank();
        ArrayList<Account> emptyList = new ArrayList<>();
        Customer customer = new Customer("Program2","prg@email.com","Prg Road 5",2,emptyList);
        bank.createAcc(customer,1);
        bank.makeDeposit(customer,1,500);

        Assertions.assertEquals("",bank.seeTransactions(customer,1));
    }

    @Test
    public void testTransactions(){
        Bank bank = new Bank();
        ArrayList<Account> emptyList = new ArrayList<>();
        Customer customer = new Customer("Program2","prg@email.com","Prg Road 5",2,emptyList);
        Account account = customer.getAccounts().get(0);
        bank.createAcc(customer,1);
        bank.makeDeposit(customer,1,500);

        Assertions.assertEquals(500,account.getBalance());

        bank.makeWithdraw(customer,1,250);
        Assertions.assertEquals(250,account.getBalance());
    }


}
