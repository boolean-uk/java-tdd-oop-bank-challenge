package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionTest {
    private Account account;

    @Test
    public void testTransactionCreation_Deposit(){
        account=new Account("12312312313");
        Assertions.assertEquals(0,account.getBalance());
        Assertions.assertEquals(0,account.getTransactions().size());

        double depositAmount =1000;
        Assertions.assertTrue(account.deposit(depositAmount));
        Assertions.assertEquals(1000,account.getBalance());
        Assertions.assertEquals(1,account.getTransactions().size());
        Assertions.assertEquals(TransactionType.CREDIT,account.getTransactions().get(0).getType());

    }
    @Test
    public void testTransactionCreation_Withdraw(){
        account=new Account("12312312313001");
        Assertions.assertTrue(account.deposit(2000));
        Assertions.assertEquals(1,account.getTransactions().size());

        Assertions.assertTrue(account.withdraw(1500)); // current balance 500
        Assertions.assertEquals(2,account.getTransactions().size());

        Assertions.assertEquals(500,account.getBalance());
        Assertions.assertEquals(TransactionType.DEBIT,account.getTransactions().get(1).getType());

    }
}
