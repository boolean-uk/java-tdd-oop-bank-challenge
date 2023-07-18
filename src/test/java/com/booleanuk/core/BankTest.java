package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void createSavingsAccountTest(){
        Bank bank = new Bank();
        Assertions.assertEquals(1,bank.openSavingsAccount("Jan Lisek","00003"));
        Assertions.assertEquals("Jan Lisek", bank.getSavingsAccounts().get(0).getAccountOwner());
    }

    @Test
    public void createCurrentAccountTest(){
        Bank bank = new Bank();
        Assertions.assertEquals(1,bank.openCurrentAccount("Jan Lisek","00003"));
        Assertions.assertEquals("Jan Lisek", bank.getCurrentAccounts().get(0).getAccountOwner());
    }

    @Test
    public void overdraftRequestsTest(){
        Bank bank = new Bank();
        bank.openSavingsAccount("Jan Lisek","00003");
        Assertions.assertNull(bank.checkForOverdraftRequests(0));
        account.createOverdraftRequest(100);
        OverdraftRequest request = bank.checkForOverdraftRequests(0);
        Assertions.assertEquals(100,request.getAmount());
        Assertions.assertEquals("You approved overdraft", bank.approveOverdraftRequest(request));
        account.createOverdraftRequest(200);
        OverdraftRequest request2 = bank.checkForOverdraftRequests(0);
        Assertions.assertEquals("You rejected overdraft", bank.rejectOverdraftRequest(request2));
    }
}
