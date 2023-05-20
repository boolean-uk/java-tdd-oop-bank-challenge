package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void testRequestOverdraft() {
        Bank bank = new Bank();
        bank.getAccounts().add(new CurrentAccount(0, new Branch("xxx", "xx")));
        bank.getAccounts().add(new SavingAccount(0, new Branch("xxx", "xx")));

        bank.requestOverdraft(bank.getAccounts().get(0));
        bank.requestOverdraft(bank.getAccounts().get(1));

        Assertions.assertEquals(2, bank.getOverdraftRequests().size());
    }

    @Test
    public void testOverdraftApproval() {
        // Adding accounts to the bank
        Bank bank = new Bank();
        bank.getAccounts().add(new CurrentAccount(0, new Branch("xxx", "xx")));
        bank.getAccounts().add(new SavingAccount(0, new Branch("xxx", "xx")));
        bank.getAccounts().add(new SavingAccount(0, new Branch("xxx", "xx")));

        // Adding/making overdraft requests
        bank.requestOverdraft(bank.getAccounts().get(0));
        bank.requestOverdraft(bank.getAccounts().get(1));

        // Testing for approval only for CurrentAccount
        Assertions.assertEquals("Approved", bank.overdraftApproval(bank.getAccounts().get(0)));
        Assertions.assertEquals("Rejected", bank.overdraftApproval(bank.getAccounts().get(1)));
        // Testing for bad request, for accounts that are not in the request array
        Assertions.assertEquals("Invalid request", bank.overdraftApproval(bank.getAccounts().get(2)));
    }

}
