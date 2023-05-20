package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SavingAccountTest {
    @Test
    public void testCreateAccountWithBranch(){
        SavingAccount account = new SavingAccount(0, new Branch("123","Somewhere"));
        Assertions.assertEquals("123",account.getBranch().getCode());
        Assertions.assertEquals("Somewhere",account.getBranch().getAddress());
    }
    @Test
    public void testGetBalanceBasedOnTransactionHistory(){
        SavingAccount account = new SavingAccount(0,new Branch("xxxx","xxxx"));
        account.deposit(1000.00, LocalDate.of(2012,1,10));
        account.deposit(2000.00,LocalDate.of(2012,1,13));
        account.withdraw(500.00,LocalDate.of(2012,1,14));

        Assertions.assertEquals(2500,account.getBalance());
    }

    @Test
    public void testGenerateStatementBasedOnTransactions() {
        // This test will also test of withdraw and deposit method
        SavingAccount account = new SavingAccount(0, new Branch("xxx","xxx"));
        account.deposit(1000.00, LocalDate.of(2012, 1, 10));
        account.deposit(2000.00, LocalDate.of(2012, 1, 13));
        account.withdraw(500.00, LocalDate.of(2012, 1, 14));

        account.generateStatement();
        Assertions.assertEquals(2500, account.getBalance());
    }
    @Test
    public void testWithdraw(){
        SavingAccount account = new SavingAccount(0,new Branch("xxxx","xxxx"));
        account.deposit(1000.00,LocalDate.of(2012,1,14));
        String message = account.withdraw(500.00,LocalDate.of(2012,1,14));

        // Test should pass
        Assertions.assertEquals("Transaction succeeded",message);
        Assertions.assertEquals(500,account.getBalance());

        // Test for overdraft should fail
        message = account.withdraw(600.00,LocalDate.of(2012,1,14));
        Assertions.assertEquals("Overdraft not allowed",message);
        Assertions.assertEquals(500,account.getBalance());
    }
}
