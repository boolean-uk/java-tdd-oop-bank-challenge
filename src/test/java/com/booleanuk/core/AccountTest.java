package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void testAdd(){
        Account account = new SavingsAccount();

        //Add
        Assertions.assertEquals(0, account.getBalance());
        account.add(50);
        Assertions.assertEquals(50, account.getBalance());

    }

    @Test
    public void testRemove(){
        Account account = new SavingsAccount();

        account.add(500);
        account.remove(200);
        Assertions.assertEquals(300, account.getBalance());

    }

    @Test
    public void testGetTransactions(){
        Account account = new SavingsAccount();
        account.add(500);
        account.remove(200);
        Assertions.assertEquals(300, account.getBalance());

        List<Transaction> testList = new ArrayList<>()
        testList.add(new Transaction(500));
        testList.add(new Transaction(-200));

        Assertions.assertEquals(testList.get(0).getDate(), account.getTransactions().get(0).getDate());
        Assertions.assertEquals(testList.get(1).getAmount(), account.getTransactions().get(1).getAmount());
    }

    @Test
    public void testGetAccountNr(){
        Account account = new SavingsAccount();
        Account account2 = new CurrentAccount();
        Assertions.assertEquals(1, account.getAccountNr());
        Assertions.assertEquals(2, account2.getAccountNr());
    }

}