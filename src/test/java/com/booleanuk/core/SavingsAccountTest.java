package com.booleanuk.core;

import com.booleanuk.extension.NormalAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    public void shouldCreateSavingslAccountWithBalanceEquals0AndTransactionsListEmpty() {
        SavingsAccount savingsAccount = new SavingsAccount(12312312);
        Assertions.assertEquals(0, savingsAccount.getBalance());
        Assertions.assertEquals(0, savingsAccount.getTransactions().size());
    }

    @Test
    public void shouldReturnTrueWhenUserDepositPositiveValueOfMoney() {
        SavingsAccount savingsAccount = new SavingsAccount(12312312);
        Assertions.assertTrue(savingsAccount.deposit(123));
    }

    @Test
    public void shouldSetBalanceTo123() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.deposit(123);
        Assertions.assertEquals(123, normalAccount.getBalance());
    }

    @Test
    public void shouldntChangeBalance() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.deposit(-123);
        Assertions.assertEquals(0, normalAccount.getBalance());
    }

    @Test
    public void shouldReturnFalseWhenUserDepositNegativeValueOfMoneyOrNoMoney() {
        SavingsAccount savingsAccount = new SavingsAccount(12312312);
        Assertions.assertFalse(savingsAccount.deposit(-123));
        Assertions.assertFalse(savingsAccount.deposit(0));
    }

    @Test
    public void shouldReturnTrueWhenEnoughMoneyOnAccountToWithdraw() {
        SavingsAccount savingsAccount = new SavingsAccount(12312312);
        savingsAccount.deposit(123);
        Assertions.assertTrue(savingsAccount.withdraw(11));
    }

    @Test
    public void shouldReturnFalseWhenNotEnoughMoneyOnAccountToWithdraw() {
        SavingsAccount savingsAccount = new SavingsAccount(12312312);
        Assertions.assertFalse(savingsAccount.withdraw(11));
    }

}
