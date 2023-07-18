package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NormalAccountTest {

    @Test
    public void shouldCreateNormalAccountWithBalanceEquals0AndTransactionsListEmpty() {
        NormalAccount normalAccount = new NormalAccount(12312312);

        Assertions.assertEquals(0, normalAccount.getBalance());
        Assertions.assertEquals(0, normalAccount.getTransactions().size());
        Assertions.assertEquals(12312312, normalAccount.getAccountNumber());
        Assertions.assertEquals(-500, normalAccount.getDebit());
    }

    @Test
    public void shouldReturnTrueWhenUserDepositPositiveValueOfMoney() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        Assertions.assertTrue(normalAccount.deposit(123));
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
        NormalAccount normalAccount = new NormalAccount(12312312);
        Assertions.assertFalse(normalAccount.deposit(-123));
        Assertions.assertFalse(normalAccount.deposit(0));
    }

    @Test
    public void shouldReturnTrueWhenEnoughMoneyOnAccountToWithdraw() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.deposit(123);
        Assertions.assertTrue(normalAccount.withdraw(11));
    }

    @Test
    public void shouldReturnFalseWhenNotEnoughMoneyOnAccountToWithdraw() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        Assertions.assertFalse(normalAccount.withdraw(11));
    }

    @Test
    public void shouldAddNewTransactionToTransactionsListAfterCorrectDeposit() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.deposit(123);
        Assertions.assertEquals(1, normalAccount.getTransactions().size());
    }

    @Test
    public void shouldAddNewTransactionToTransactionsListAfterCorrectWithdrawal() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.deposit(123);
        normalAccount.withdraw(123);
        Assertions.assertEquals(2, normalAccount.getTransactions().size());
    }

    @Test
    public void shouldntAddNewTransactionToTransactionsListAfterIncorrectDeposit() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.deposit(-123);
        Assertions.assertEquals(0, normalAccount.getTransactions().size());
    }

    @Test
    public void shouldntAddNewTransactionToTransactionsListAfterIncorrectWithdrawal() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.withdraw(123);
        Assertions.assertEquals(0, normalAccount.getTransactions().size());
    }

    @Test
    public void shouldAddNewTransactionToTransactionsListAfterCorrectWithdrawalFromDebit() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.withdrawFromDebit(123);
        Assertions.assertEquals(1, normalAccount.getTransactions().size());
    }

    @Test
    public void shouldntAddNewTransactionToTransactionsListAfterIncorrectWithdrawalFromDebit() {
        NormalAccount normalAccount = new NormalAccount(12312312);
        normalAccount.withdrawFromDebit(600);
        Assertions.assertEquals(0, normalAccount.getTransactions().size());
    }

    @Test
    public void shouldReturnNoTransactionsStatementWhenTransactionsIsEmpty() {
        NormalAccount normalAccount = new NormalAccount(123123123);
        Assertions.assertEquals("No Transactions done before", normalAccount.generateStatement().toString());
    }

    @Test
    public void shouldReturnTransactionsStatementWhenTransactionsIsNotEmpty() {
        NormalAccount normalAccount = new NormalAccount(123123123);
        normalAccount.deposit(123);
        System.out.println(normalAccount.generateStatement());
        Assertions.assertNotEquals("No Transactions done before", normalAccount.generateStatement().toString());
    }

    @Test
    public void shouldReturnTransactionsStatementWhenTransactionsIsNotEmptyMoreTransactions() {
        NormalAccount normalAccount = new NormalAccount(123123123);
        normalAccount.deposit(1000);
        normalAccount.deposit(2000);
        normalAccount.withdraw(500);

        System.out.println(normalAccount.generateStatement());
        Assertions.assertNotEquals("No Transactions done before", normalAccount.generateStatement().toString());
    }

    @Test
    public void shouldCreateAccountWithBranchWarsaw() {
        NormalAccount normalAccount = new NormalAccount(123123, "Warsaw");
        Assertions.assertEquals("Warsaw", normalAccount.getBranch());
    }

    @Test
    public void shouldWithdrawFromDebitBeAcceptedAndDoneProperlyAndSetAccBalance()
    {
        NormalAccount normalAccount = new NormalAccount(12312312,"Warsaw");
        Assertions.assertTrue(normalAccount.requestForOverdraft(300));
        Assertions.assertEquals(-300,normalAccount.getBalance());
        Assertions.assertEquals(-500, normalAccount.getDebit());

    }

    @Test
    public void shouldWithdrawFromDebitBeAcceptedAndDoneProperlyTwoTimes()
    {
        NormalAccount normalAccount = new NormalAccount(12312312,"Warsaw");
        Assertions.assertTrue(normalAccount.requestForOverdraft(300));
        Assertions.assertEquals(-300,normalAccount.getBalance());
        Assertions.assertEquals(-500, normalAccount.getDebit());
        Assertions.assertTrue(normalAccount.requestForOverdraft(100));
        Assertions.assertEquals(-400,normalAccount.getBalance());
        Assertions.assertEquals(-500, normalAccount.getDebit());
        Assertions.assertFalse(normalAccount.requestForOverdraft(300));
        Assertions.assertEquals(-400,normalAccount.getBalance());
    }
}
