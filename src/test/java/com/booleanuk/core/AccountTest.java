package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        // Create a new account instance
        account = new Account("1234567890");
    }
    @Test
    public void testDeposit(){
        Assertions.assertEquals(0,account.getBalance());
        double depositAmount =1000;
        Assertions.assertTrue(account.deposit(depositAmount));
        Assertions.assertEquals(1000,account.getBalance());
    }
    @Test
    public void testWithdraw(){
        Assertions.assertTrue(account.deposit(2000));

        Assertions.assertTrue(account.withdraw(1500)); // current balance 500
        Assertions.assertEquals(500,account.getBalance());

        Assertions.assertFalse(account.withdraw(1000)); //not enough balance, balance remains 500
        Assertions.assertEquals(500,account.getBalance());

    }
    @Test
    public void testGetStatement_EmptyStatement() {
        // Ensure an empty statement when there are no transactions
        String expectedStatement = "No transactions available.";
        String actualStatement = account.getStatement();
        Assertions.assertEquals(expectedStatement, actualStatement);
    }
    @Test
    public void testGetStatement_MultipleTransactions() throws ParseException {
        // Create mock transactions
        Transaction transaction1 = Mockito.mock(Transaction.class);
        Mockito.when(transaction1.getDate()).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2023"));
        Mockito.when(transaction1.getAmount()).thenReturn(150.0);
        Mockito.when(transaction1.getCurrentBalance()).thenReturn(150.0);
        Mockito.when(transaction1.getType()).thenReturn(TransactionType.CREDIT);

        Transaction transaction2 = Mockito.mock(Transaction.class);
        Mockito.when(transaction2.getDate()).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2023"));
        Mockito.when(transaction2.getAmount()).thenReturn(50.0);
        Mockito.when(transaction2.getCurrentBalance()).thenReturn(100.0);

        Mockito.when(transaction2.getType()).thenReturn(TransactionType.DEBIT);

        // Add the transactions to the account
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        account.setTransactions(transactions);

        // Define the expected statement
        String expectedStatement =
                "date       || credit  || debit  || balance\n" +
                        "02/05/2023 ||         || 50.00 || 100.00\n" +
                        "01/05/2023 || 150.00 ||        || 150.00";

        // Compare the expected statement with the actual statement
        String actualStatement = account.getStatement();
        Assertions.assertEquals(expectedStatement, actualStatement);
    }
}

