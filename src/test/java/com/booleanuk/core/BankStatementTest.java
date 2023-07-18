package com.booleanuk.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankStatementTest {
    private final String accountNumber = "1234 5678 9012 3456";
    private BankStatement bankStatement;

    private final List<Transaction> transactions = List.of(
        new Transaction(1000.00d, "10/01/2012", TransactionType.CREDIT, 1000.0d),
        new Transaction(3000.00d, "13/01/2012", TransactionType.CREDIT, 2000.0d),
        new Transaction(2500.00d, "14/01/2012", TransactionType.DEBIT, 500.0d)
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
        String expected =
                "date       || credit  || debit  || balance" + System.lineSeparator() +
                "14/01/2012 ||         || 500.00 || 2500.00" + System.lineSeparator() +
                "13/01/2012 || 2000.00 ||        || 3000.00" + System.lineSeparator() +
                "10/01/2012 || 1000.00 ||        || 1000.00" + System.lineSeparator();

        Assertions.assertEquals(expected, actual);
    }

}
