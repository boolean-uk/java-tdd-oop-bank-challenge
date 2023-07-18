package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OverdraftRequestTest {

    @Test
    public void testOverdraftRequestAndApproval() {
        Bank bank = new Bank();
        bank.addCustomer(1);
        bank.addAccount(1, "Savings", 1000);

        Account account = bank.getCustomers().get(0).getAccounts().get(0);
        Assertions.assertEquals(1000, account.getBalance());

        account.addOverdraft(500);

        bank.evaluateOverdraft(account.getId(), true);

        Assertions.assertEquals(1500, account.getBalance());
        Assertions.assertTrue(account.getOverdraftRequests().get(0).isApproved());
    }

    @Test
    public void testOverdraftRequestAndDisapproval() {
        Bank bank = new Bank();
        bank.addCustomer(1);
        bank.addAccount(1, "Savings", 1000);

        Account account = bank.getCustomers().get(0).getAccounts().get(0);
        Assertions.assertEquals(1000, account.getBalance());

        account.addOverdraft(500);

        bank.evaluateOverdraft(account.getId(), false);

        Assertions.assertEquals(1000, account.getBalance());
        Assertions.assertFalse(account.getOverdraftRequests().get(0).isApproved());
    }
}
