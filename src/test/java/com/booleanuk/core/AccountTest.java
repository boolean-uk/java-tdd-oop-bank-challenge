package com.booleanuk.core;

import com.booleanuk.core.bank.Account;
import com.booleanuk.core.bank.CurrentAccount;
import com.booleanuk.core.bank.SavingsAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    public AccountTest() {

    }

    @Test
    public void testCreateCurrentAccount() {
        Account currentAccount = new CurrentAccount();

        Assertions.assertTrue(currentAccount.getAccountNumber() == "");
    }

    @Test
    public void testCreateSavingsAccount() {
        Account savingsAccount = new SavingsAccount(1.1);

        Assertions.assertTrue(savingsAccount.getAccountNumber() == "");
    }

}
