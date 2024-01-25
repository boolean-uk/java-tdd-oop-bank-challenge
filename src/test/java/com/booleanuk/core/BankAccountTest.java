package com.booleanuk.core;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class BankAccountTest {

    @Test
    void generateStatementAcceptanceTest() {
        BankAccount bankAccount = new BankAccount("Savings");

        bankAccount.deposit(1000, "10-01-2012");
        bankAccount.deposit(2000, "13-01-2012");
        bankAccount.withdraw(500, "14-01-2012");

        String actualStatement = bankAccount.generateStatement();

        String expectedStatement = "date       || credit  || debit  || balance\n" +
                "14/01/2012 ||  || 500.00 || 2500.00\n" +
                "13/01/2012 || 2000.00 ||  || 3000.00\n" +
                "10/01/2012 || 1000.00 ||  || 1000.00";

        assertArrayEquals(expectedStatement.split("\n"), actualStatement.split("\n"));
    }
}

