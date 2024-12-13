package com.booleanuk.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public class BankStatementTest {
    private final String accountNumber = "1234 5678 9012 3456";
    private BankStatement bankStatement;
    private final List<LocalDateTime> dates = List.of(
        LocalDateTime.of(2012, 1, 10, 0, 0),
        LocalDateTime.of(2012, 1, 13, 0, 0),
        LocalDateTime.of(2012, 1, 14, 0, 0)
    );

    private final List<Transaction> transactions = List.of(
        new Transaction(1000.00d, dates.get(0), TransactionType.CREDIT, 1000.0d),
        new Transaction(3000.00d, dates.get(1), TransactionType.CREDIT, 2000.0d),
        new Transaction(2500.00d, dates.get(2), TransactionType.DEBIT, 500.0d)
    );

    @BeforeEach
    public void setUp() {
        bankStatement = new BankStatement(accountNumber);
    }

    @Test
    public void testAddTransaction() {
        for (Transaction transaction : transactions) {
            bankStatement.addTransaction(transaction);
        }
        Assertions.assertEquals(transactions, bankStatement.getTransactions());
    }

    @Test
    public void testGetAccountNumber() {
        Assertions.assertEquals(accountNumber, bankStatement.getAccountNumber());
    }

    @Test
    public void testToString() {
        for (Transaction transaction : transactions) {
            bankStatement.addTransaction(transaction);
        }

        String actual = bankStatement.toString();
        String expected = "Statement for account number: " + accountNumber + System.lineSeparator() +
                "date       || credit  || debit  || balance" + System.lineSeparator() +
                "14/01/2012 ||         || 500.00 || 2500.00" + System.lineSeparator() +
                "13/01/2012 || 2000.00 ||        || 3000.00" + System.lineSeparator() +
                "10/01/2012 || 1000.00 ||        || 1000.00" + System.lineSeparator();

        Assertions.assertEquals(expected, actual);
    }

}
