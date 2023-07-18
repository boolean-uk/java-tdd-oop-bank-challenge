package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CurrentAccountTest {
    @Test
    public void testDeposit(){
        // the test should increase the balance and add a transaction of type CREDIT
        CurrentAccount account = new CurrentAccount(0);
        account.deposit(100.00, LocalDate.of(2023,5,19));

        Assertions.assertEquals(100.00,account.getBalance());

        Assertions.assertEquals(1,account.getTransactions().size());
        Assertions.assertEquals(TransactionType.CREDIT,account.getTransactions().get(0).getType());
    }
    @Test
    public void testWithdraw(){
        // the test should decrease the balance and add a transaction of type DEBIT
        CurrentAccount account = new CurrentAccount(0);
        account.deposit(100.00, LocalDate.of(2023,5,19));
        account.deposit(100.00, LocalDate.of(2023,5,19));
        account.deposit(100.00, LocalDate.of(2023,5,19));

        Assertions.assertEquals(300.00,account.getBalance());
        account.withdraw(100.00, LocalDate.of(2023,5,19));

        Assertions.assertEquals(200.00,account.getBalance());
        Assertions.assertEquals(4,account.getTransactions().size());
        Assertions.assertEquals(TransactionType.DEBIT,account.getTransactions().get(3).getType());
    }
    @Test
    public void testGenerateStatement(){
        CurrentAccount account = new CurrentAccount(0);
        account.deposit(1000.00, LocalDate.of(2012,1,10));
        account.deposit(2000.00,LocalDate.of(2012,1,13));
        account.withdraw(500.00,LocalDate.of(2012,1,14));

        account.generateStatement();
        Assertions.assertEquals(2500,account.getBalance());
    }
}
