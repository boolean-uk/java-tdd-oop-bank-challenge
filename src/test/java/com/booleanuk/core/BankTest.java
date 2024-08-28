package com.booleanuk.core;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.CurrentAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void makeRequest() {
        Bank bank = new Bank();

        Account account = new CurrentAccount();
        Request request = new Request(account, 100.00);

        bank.makeRequest(request);
        Assertions.assertEquals(1, bank.getAllRequests().size());
    }

    // TODO: if time, test remove() or add wrapper function called delete

}
