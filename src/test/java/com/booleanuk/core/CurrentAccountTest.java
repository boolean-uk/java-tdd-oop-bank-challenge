package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    @Test
    public void initCurrentAccount() {

        Account currentAccount = new CurrentAccount("AccountName", Branches.Oslo);

    }

    @Test
    public void withdrawMoreThanNullWithOverdraft() {

        Customer customer = new Customer();

        CurrentAccount currentAccount = new CurrentAccount("AccountName", Branches.Oslo);

        BankManager bankManager = new BankManager();

        customer.createAccount(currentAccount);

        Overdraft overdraft = new Overdraft(500);
        Overdraft overdraft2 = new Overdraft(400);


        customer.requestOverdraft(currentAccount, bankManager, overdraft);

        bankManager.rejectOverdraft(overdraft);

        Assertions.assertFalse(customer.withdraw(currentAccount, 400));

        bankManager.addOverDraft(overdraft2);
        bankManager.approveOverdraft(overdraft2);

        Assertions.assertTrue(customer.withdraw(currentAccount, 400));

    }

}
