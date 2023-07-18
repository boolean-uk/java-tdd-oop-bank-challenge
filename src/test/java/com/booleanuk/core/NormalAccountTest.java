package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NormalAccountTest {

    @Test
    public void shouldCreateNormalAccountWithBalanceEquals0AndTransactionsListEmpty()
    {
        NormalAccount normalAccount = new NormalAccount(12312312);

        Assertions.assertEquals(0,normalAccount.getBalance());
        Assertions.assertEquals(0,normalAccount.getTransactions().size());
    }
    @Test
    public  void shouldReturnTrueWhenUserDepositPositiveValueOfMoney()
    {
        NormalAccount normalAccount = new NormalAccount(12312312);
        Assertions.assertTrue(normalAccount.deposit(123));
    }

    @Test
    public  void shouldSetBalanceTo123()
    {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.deposit(123);
        Assertions.assertEquals(123,normalAccount.getBalance());
    }
    @Test
    public  void shouldntChangeBalance()
    {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.deposit(-123);
        Assertions.assertEquals(0,normalAccount.getBalance());
    }
    @Test
    public  void shouldReturnFalseWhenUserDepositNegativeValueOfMoneyOrNoMoney()
    {
        NormalAccount normalAccount = new NormalAccount(12312312);
        Assertions.assertFalse(normalAccount.deposit(-123));
        Assertions.assertFalse(normalAccount.deposit(0));
    }

    @Test
    public  void shouldReturnTrueWhenEnoughMoneyOnAccountToWithdraw()
    {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.deposit(123);
        Assertions.assertTrue(normalAccount.withdraw(11));
    }
    @Test
    public  void shouldReturnFalseWhenNotEnoughMoneyOnAccountToWithdraw()
    {
        NormalAccount normalAccount = new NormalAccount(12312312);
        Assertions.assertFalse(normalAccount.withdraw(11));
    }
    @Test
    public void shouldReturnTrueWhenEnoughMoneyOnDebitToWithdraw()
    {
        NormalAccount normalAccount = new NormalAccount(12312312);
        Assertions.assertTrue(normalAccount.withdrawFromDebit(25));
    }
    @Test
    public void shouldReturnFalseWhenNotEnoughMoneyOnDebitToWithdraw()
    {
        NormalAccount normalAccount = new NormalAccount(12312312);
        Assertions.assertFalse(normalAccount.withdrawFromDebit(1111));
    }
}
