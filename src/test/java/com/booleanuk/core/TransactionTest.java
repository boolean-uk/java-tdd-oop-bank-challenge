package com.booleanuk.core;

import com.booleanuk.core.bank.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    public TransactionTest() {
    }

    @Test
    public void testCreateTransactionDeposit() {
        Bank bank = new Bank("Swedbank");
        Customer customer = bank.addCustomer(new Customer());
        Account account = bank.newAccount(customer, new SavingsAccount(Account.Branch.GOTHENBURG, 1.1));
        final double amount = 1000;

        bank.deposit(customer, account, amount);

        Transaction firstTransaction = customer.getTransactions().getFirst();

        // Assertions.assertEquals("2024-08-26", firstTransaction.getDate()); // obviously hard to hard code date for testing
        Assertions.assertEquals(account.getAccountNumber(), firstTransaction.getFromAccount().getAccountNumber());
        Assertions.assertEquals(amount, firstTransaction.getAmount());
        Assertions.assertEquals(customer.getBalance(account) - amount, firstTransaction.getBalanceBeforeTransaction());
        Assertions.assertEquals(Transaction.TransactionType.CREDIT, firstTransaction.getTransactionType());
    }

    @Test
    public void testCreateTransactionWithdraw() {
        Bank bank = new Bank("Swedbank");
        Customer customer = bank.addCustomer(new Customer());
        Account account = bank.newAccount(customer, new CurrentAccount(Account.Branch.GOTHENBURG));
        final double amount = 1000;

        bank.withdraw(customer, account, amount);

        Transaction firstTransaction = customer.getTransactions().getFirst();


        Assertions.assertEquals(account.getAccountNumber(), firstTransaction.getFromAccount().getAccountNumber());
        Assertions.assertEquals(amount, firstTransaction.getAmount());
        Assertions.assertEquals(0, firstTransaction.getBalanceBeforeTransaction());
        Assertions.assertEquals(Transaction.TransactionType.DEBIT, firstTransaction.getTransactionType());
    }

    @Test
    public void testCreateTransactionDepositAndWithdraw() {
        Bank bank = new Bank("Swedbank");
        Customer customer = bank.addCustomer(new Customer());
        Account account = bank.newAccount(customer, new CurrentAccount(Account.Branch.GOTHENBURG));
        final double depositAmount = 1000;
        final double withdrawAmount = 500;

        bank.deposit(customer, account, depositAmount);

        // deposit transaction
        Transaction depositTransaction = customer.getTransactions().getFirst();
        Assertions.assertEquals(account.getAccountNumber(), depositTransaction.getFromAccount().getAccountNumber());
        Assertions.assertEquals(depositAmount, depositTransaction.getAmount());
        Assertions.assertEquals(depositAmount - customer.getBalance(account), depositTransaction.getBalanceBeforeTransaction());

        bank.withdraw(customer, account, withdrawAmount);

        // withdraw transaction
        Transaction withdrawTransaction = customer.getTransactions().getFirst(); // Latest transaction will be first
        Assertions.assertEquals(account.getAccountNumber(), withdrawTransaction.getFromAccount().getAccountNumber());
        Assertions.assertEquals(withdrawAmount, withdrawTransaction.getAmount());
        Assertions.assertEquals(customer.getBalance(account) + withdrawAmount, withdrawTransaction.getBalanceBeforeTransaction());
    }

}
