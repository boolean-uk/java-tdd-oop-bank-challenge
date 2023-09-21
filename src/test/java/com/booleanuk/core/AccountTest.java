package com.booleanuk.core;

import com.booleanuk.CurrentAccount;
import com.booleanuk.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testCreateCurrentAccount() {
        CurrentAccount currentAccount = new CurrentAccount();

        Assertions.assertEquals(0.0, currentAccount.getBalance());
        Assertions.assertEquals(0, currentAccount.getTransactions().size());
    }

    @Test
    public void testCreateSavingAccount() {
        SavingAccount currentAccount = new SavingAccount();

        Assertions.assertEquals(0.0, currentAccount.getBalance());
        Assertions.assertEquals(0, currentAccount.getTransactions().size());
    }
}
