package com.booleanuk.core.bank;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void makeRequest() {
        Bank bank = new Bank();
        User customer = bank.createUser("P_#1");

        bank.createUserAccount(customer, AccountType.CURRENT);
        Account account = customer.getAllAccounts().get(0);

        bank.makeRequest(account, 100.00);
        Assertions.assertEquals(1, bank.getAllRequests().size());
    }

    // TODO: if time, test remove() or add wrapper function called delete

}
