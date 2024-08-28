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

    @Test
    public void depositMoney() {
        Account currentAccount = new CurrentAccount();
        currentAccount.deposit(1000.00);
        Assertions.assertEquals(1000.00, currentAccount.getBalance());

        Account savingtAccount = new SavingsAccount();
        savingtAccount.deposit(1000.00);
        Assertions.assertEquals(1000.00, savingtAccount.getBalance());
    }

    @Test
    public void withdrawMoney() {
        Account currentAccount = new CurrentAccount();
        currentAccount.withdraw(1000.00);
        Assertions.assertEquals(-1000.00, currentAccount.getBalance());

        Account savingtAccount = new SavingsAccount();
        // Inner validate function should throw error
        Exception e = Assertions.assertThrows(
                Exception.class,
                () -> { savingtAccount.validateOverdraft(savingtAccount.getBalance(), 1000.00); }
        );
        Assertions.assertEquals("Not possible to overdraft", e.getMessage());

        // Outer function .withdraw() should handle error
        Assertions.assertDoesNotThrow(() -> savingtAccount.withdraw(1000.0));
    }
}
