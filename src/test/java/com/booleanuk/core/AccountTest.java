package com.booleanuk.core;

import com.booleanuk.core.extension.BankBranch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AccountTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void shouldGenerateStatement() {
        //Setup
        CurrentAccount currentAccount = new CurrentAccount(BankBranch.PARIS1);
        Transaction transaction = new Transaction(currentAccount);
        currentAccount.transactions.add(transaction);
        transaction.deposit(100);
        String expected = String.format("%-10s || %-8s || %-8s || %-8s\n", "date", "credit", "debit", "balance") +
                String.format("%-10s || %.2f || %-8s || %.2f", transaction.getLocalDateFormatted(),
                        transaction.getDeposit(), "", transaction.getBalance());
        //Execute
        currentAccount.generateStatement();

        //Verify
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());

    }
}