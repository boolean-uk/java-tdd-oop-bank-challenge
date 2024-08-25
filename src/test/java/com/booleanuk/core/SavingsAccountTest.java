package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    Account account;
    // I won't be writing tests for getter/setters unless they do something special. I'll instead focus on writing more meaningful tests for other methods
    @BeforeEach
    public void dummyData() {
        account = new SavingsAccount("12345");

    }
    @Test
    public void constructorTest() {
        Assertions.assertEquals("12345", account.getIdentifier());
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertTrue(account.getTransactions().isEmpty());
    }

    @Test
    public void depositTest() {
        account.deposit(500);
        Assertions.assertEquals(500, account.getBalance());
        Assertions.assertFalse(account.getTransactions().isEmpty());
        Assertions.assertEquals(500, account.getTransactions().get(0).getAmount());
        Assertions.assertEquals(TransactionType.DEPOSIT, account.getTransactions().get(0).getType());
    }

    @Test
    public void withdrawalTest() {
        account.withdrawal(100);
        Assertions.assertTrue(account.getTransactions().isEmpty()); // No transaction should happen when the withdrawl is invalid
        Assertions.assertEquals(0, account.getBalance()); // The balance should remain unchanged
        account.deposit(400);
        account.withdrawal(250);
        Assertions.assertEquals(150, account.getBalance());
        Assertions.assertEquals(250, account.getTransactions().get(1).getAmount());
        Assertions.assertEquals(TransactionType.WITHDRAWAL, account.getTransactions().get(1).getType());
    }


    @Test
    public void getBankStatementTest() {
        account.deposit(1000);
        account.deposit(2000);
        account.withdrawal(500);

        String bankStatementTest = "      Date ||       Type ||     Amount ||    Balance \n" +
                "2024-01-25 ||    DEPOSIT ||       1000 ||       1000 \n" +
                "2024-01-25 ||    DEPOSIT ||       2000 ||       3000 \n" +
                "2024-01-25 || WITHDRAWAL ||        500 ||       2500 \n";
        Assertions.assertEquals(bankStatementTest, account.getBankStatement());

    }
}
