package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AccountTest {

    @BeforeEach
    void setUp() {
        Account.resetLastAccountNumber();
    }

    @Test
    public void testAdd(){
        Account account = new SavingsAccount(Branch.COPENHAGEN);

        //Add
        Assertions.assertEquals(0, account.getBalance());
        account.add(50);
        Assertions.assertEquals(50, account.getBalance());

    }

    @Test
    public void testRemove(){
        Account account = new SavingsAccount(Branch.COPENHAGEN);

        account.add(500);
        account.remove(200);
        Assertions.assertEquals(300, account.getBalance());

    }

    @Test
    public void testGetTransactions(){
        Account account = new SavingsAccount(Branch.COPENHAGEN);
        account.add(500);
        account.remove(200);
        Assertions.assertEquals(300, account.getBalance());

        List<Transaction> testList = new ArrayList<>();
        testList.add(new Transaction(500, 500));
        testList.add(new Transaction(-200, 300));

        Assertions.assertEquals(testList.get(0).getDate(), account.getTransactions().get(0).getDate());
        Assertions.assertEquals(testList.get(1).getAmount(), account.getTransactions().get(1).getAmount());
    }

    @Test
    public void testGetAccountNr(){
        Account account = new SavingsAccount(Branch.COPENHAGEN);
        Account account2 = new CurrentAccount(Branch.COPENHAGEN);
        Assertions.assertEquals(1, account.getAccountNr());
        Assertions.assertEquals(2, account2.getAccountNr());
    }

    @Test
    public void testGetBranch(){
        com.booleanuk.core.Account account = new SavingsAccount(Branch.GOTHENBURG);

        Assertions.assertEquals(Branch.GOTHENBURG, account.getBranch());

    }

}