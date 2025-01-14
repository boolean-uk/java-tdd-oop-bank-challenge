package com.booleanuk.core.bank;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestTest {

    @Test
    public  void createRequest() {

        // TODO: same as in BankTest, unsure about the right way to test
        //  when the structure is like this.

        Bank bank = new Bank();
        User customer = bank.createUser("P_#1");

        bank.createUserAccount(customer, AccountType.CURRENT);
        Account account = customer.getAllAccounts().get(0);

        bank.makeRequest(account, 100.00);
        Assertions.assertEquals(1, bank.getAllRequests().size());
    }

    @Test
    public void changeOverdraftFacility() {
        Bank bank = new Bank();
        User customer = bank.createUser("P_#1");
        bank.createUserAccount(customer, AccountType.SAVINGS);
        Account account = customer.getAllAccounts().get(0);
        bank.makeRequest(account, 100.00);

        Request request = bank.getAllRequests().get(0);
        Assertions.assertFalse(account.isPossibleToOverdraft());
        request.approve();
        Assertions.assertTrue(account.isPossibleToOverdraft());
    }
}
