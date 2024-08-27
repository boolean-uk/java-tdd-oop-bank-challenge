package com.booleanuk.core.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void createCurrentAccount() {
        Account currentAccount = new CurrentAccount();
        Assertions.assertEquals("AC_1", currentAccount.getAccountNumber());
        Assertions.assertEquals(Branch.BRANCH_1, currentAccount.getBranch());

        Account savingsAccount = new CurrentAccount();
        Assertions.assertEquals("AC_2", savingsAccount.getAccountNumber());
        Assertions.assertEquals(Branch.BRANCH_1, savingsAccount.getBranch());
    }

    @Test
    public void checkOverdraftFacility() {
        Account currentAccount = new CurrentAccount();
        Assertions.assertTrue(currentAccount.isPossibleToOverdraft());
        currentAccount.setPossibleToOverdraft(false);
        Assertions.assertFalse(currentAccount.isPossibleToOverdraft());

        Account savingsAccount = new SavingsAccount();
        Assertions.assertFalse(savingsAccount.isPossibleToOverdraft());
        savingsAccount.setPossibleToOverdraft(true);
        Assertions.assertTrue(savingsAccount.isPossibleToOverdraft());
    }
}
