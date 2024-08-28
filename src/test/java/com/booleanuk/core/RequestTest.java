package com.booleanuk.core;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.SavingsAccount;
import com.booleanuk.core.transactons.Transaction;
import com.booleanuk.core.transactons.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestTest {

    @Test
    public  void createRequest() {
        Account account = new SavingsAccount();
        Double overdraftSum = 1000.0;
        Assertions.assertEquals("RE_1", new Request(account, overdraftSum).getId());
        Assertions.assertEquals("RE_2", new Request(account, overdraftSum).getId());
    }

    @Test
    public void changeOverdraftFacility() {
        Account account = new SavingsAccount();
        Assertions.assertFalse(account.isPossibleToOverdraft());

        Request request = new Request(account, 1000.00);
        request.approve();

        Assertions.assertTrue(account.isPossibleToOverdraft());
    }
}
