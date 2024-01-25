package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void generateStatementAcceptanceTest() {
        BankAccount bankAccount = new BankAccount("Savings");

        // Given a client makes deposits and a withdrawal
        bankAccount.deposit(1000, "10-01-2012");
        bankAccount.deposit(2000, "13-01-2012");
        bankAccount.withdraw(500, "14-01-2012");

        // When she prints her bank statement
        String actualStatement = bankAccount.generateStatement();

        // Then she would see the expected statement
        String expectedStatement = "date       || credit  || debit  || balance\n" +
                "14/01/2012 ||         || 500.00 || 2500.00\n" +
                "13/01/2012 || 2000.00 ||        || 3000.00\n" +
                "10/01/2012 || 1000.00 ||        || 1000.00";

        assertEquals(expectedStatement, actualStatement);
    }
}
