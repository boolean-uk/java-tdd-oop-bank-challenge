package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class AccountTest {

    @Test
    public void initAccount() {
        Account account = new Account();

        Assertions.assertEquals(0.00, account.getBalance());
        Assertions.assertEquals(new ArrayList<BankStatement>(), account.getBankStatements());
        Assertions.assertTrue(account.addBankStatement(new DepositStatement(new Date(), 0.00, 2000.00)));
        Assertions.assertTrue(account.clearBankStatements());
        Assertions.assertTrue(account.deposit(500.00));
        Assertions.assertTrue(account.withdraw(500.00));

    }
}
