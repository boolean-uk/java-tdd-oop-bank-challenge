package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ManagerTest {
    //Extension requirements
    //
    // User story 4: Approve overdraft request
    @Test
    public void canApproveOverdraftRequest(){
        ArrayList<Account> accounts = new ArrayList<>();
        Customer customer = new Customer(accounts);
        customer.openSavingsAccount("Test Savings", Branch.Oslo);
        Account account = customer.getAccount("Test Savings");
        customer.requestOverdraft(account);

        Manager manager = new Manager();
        manager.approveOverdraftRequest(account);
        Assertions.assertEquals("Funds withdrawn from account.", account.withdraw(2000f));
    }


    // User story 4: Reject overdraft request
    @Test
    public void canRejectOverdraftRequest(){
        ArrayList<Account> accounts = new ArrayList<>();
        Customer customer = new Customer(accounts);
        customer.openSavingsAccount("Test Savings", Branch.Oslo);
        Account account = customer.getAccount("Test Savings");
        customer.requestOverdraft(account);

        Manager manager = new Manager();
        manager.denyOverdraftRequest(account);
        Assertions.assertEquals("Not enough funds.", account.withdraw(2000f));

    }
}
