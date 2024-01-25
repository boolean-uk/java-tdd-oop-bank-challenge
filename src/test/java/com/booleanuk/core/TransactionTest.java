package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TransactionTest {
    @Test
    public void checkIfTransactionsContainKeywords() {
        Bank bank = new Bank();

        bank.openCurrentAccount();

        Account account = bank.getAccounts().get(0);

        bank.depositToAccount(account, 1000);

        List<Transaction> transactions = account.getTransactions();

        String yourTransactions = Transaction.generateTransactions(transactions);

        Assertions.assertTrue(yourTransactions.contains("balance"));
    }
}
