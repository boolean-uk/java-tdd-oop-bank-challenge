package com.booleanuk.core;

import com.booleanuk.core.bank.Account;
import com.booleanuk.core.bank.Bank;
import com.booleanuk.core.bank.Customer;
import com.booleanuk.core.bank.SavingsAccount;
import com.booleanuk.core.bank.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    public TransactionTest() {
    }

    @Test
    public void testCreateTransaction() {
        Bank bank = new Bank("Swedbank");
        Customer customer = bank.addCustomer(new Customer());
        Account account = bank.newAccount(customer, new SavingsAccount(1.1));
        final double amount = 1000;

        bank.deposit(customer, account, amount);

        Transaction firstTransaction = customer.getTransactions().getFirst();

        // Assertions.assertEquals("2024-08-26", firstTransaction.getDate()); // obviously hard to hard code date for testing
        Assertions.assertEquals(account.getAccountNumber(), firstTransaction.getFromAccount().getAccountNumber());
        Assertions.assertEquals(amount, firstTransaction.getAmount());
        Assertions.assertEquals(customer.getAccount(account.getAccountNumber()).getBalance() - amount, firstTransaction.getBalanceBeforeTransaction());
    }

}
