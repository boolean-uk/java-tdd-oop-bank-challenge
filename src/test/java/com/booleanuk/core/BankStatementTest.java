package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class BankStatementTest {
    @Test
    public void testCurrentAccountDepositAndWithdraw() {

        Account currentAccount = new CurrentAccount("123456");

        currentAccount.deposit(new BigDecimal("1000"));
        currentAccount.deposit(new BigDecimal("2000"));
        currentAccount.withdraw(new BigDecimal("500"));

        List<Transaction> transactions = currentAccount.getTransactions();
        Assertions.assertEquals(3, transactions.size());

        Transaction firstTransaction = transactions.get(0);
        Assertions.assertEquals(TransactionType.DEPOSIT, firstTransaction.getType());
        Assertions.assertEquals(new BigDecimal("1000"), firstTransaction.getAmount());

        Transaction secondTransaction = transactions.get(1);
        Assertions.assertEquals(TransactionType.DEPOSIT, secondTransaction.getType());
        Assertions.assertEquals(new BigDecimal("2000"), secondTransaction.getAmount());

        Transaction thirdTransaction = transactions.get(2);
        Assertions.assertEquals(TransactionType.WITHDRAWAL, thirdTransaction.getType());
        Assertions.assertEquals(new BigDecimal("500"), thirdTransaction.getAmount());
    }

    @Test
    public void testSavingsAccountDepositAndWithdraw() {
        Account savingsAccount = new SavingsAccount("987654");

        savingsAccount.deposit(new BigDecimal("5000"));
        savingsAccount.deposit(new BigDecimal("1000"));

        List<Transaction> transactions = savingsAccount.getTransactions();
        Assertions.assertEquals(2, transactions.size());

        Transaction firstTransaction = transactions.get(0);
        Assertions.assertEquals(TransactionType.DEPOSIT, firstTransaction.getType());
        Assertions.assertEquals(new BigDecimal("5000"), firstTransaction.getAmount());

        Transaction secondTransaction = transactions.get(1);
        Assertions.assertEquals(TransactionType.DEPOSIT, secondTransaction.getType());
        Assertions.assertEquals(new BigDecimal("1000"), secondTransaction.getAmount());
    }

    @Test
    public void testBankStatement() {
        Account currentAccount = new CurrentAccount("123456");
        Account savingsAccount = new SavingsAccount("987654");

        currentAccount.deposit(new BigDecimal("1000"));
        currentAccount.deposit(new BigDecimal("2000"));
        currentAccount.withdraw(new BigDecimal("500"));

        savingsAccount.deposit(new BigDecimal("5000"));
        savingsAccount.deposit(new BigDecimal("1000"));

        BankStatement bankStatement = new BankStatement();

        System.out.println("Current Account Statement:");
        bankStatement.printStatement(currentAccount);

        System.out.println("\nSavings Account Statement:");
        bankStatement.printStatement(savingsAccount);

    }

}
