package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;
    @BeforeEach
    void setUp() {
        account = new Account("currentAccount","currentBranch");
    }

    @Test
    public void addTransactionTest_negativeAmount()
    {
        account.addTransaction("Date",-20000);
        Assertions.assertEquals(-200,account.getCurrentBalance());
    }
    @Test
    public void addTransactionTest_possitiveAmount()
    {
        account.addTransaction("Date",20000);
        Assertions.assertEquals(200,account.getCurrentBalance());
    }

    @Test
    public void getCurrentBalanceTest_possitiveAndNegativeTransaction()
    {
        account.addTransaction("Date",20000);
        account.addTransaction("Date",-10000);
        Assertions.assertEquals(100,account.getCurrentBalance());
    }
    @Test
    public void getCurrentBalanceTest_noTransactions()
    {
        Assertions.assertEquals(0,account.getCurrentBalance());
    }



   @Test
   public void generateBankStatementTest_isPrintingCorrectlyNoData()
    {
        String result = account.generateBankStatement();
        Assertions.assertEquals("date       || credit  || debit  || balance\n",result);

    }
    @Test
    public void generateBankStatementTest_isPrintingCorrectlyWithAddedTransaction()
    {
        account.addTransaction("15-04-21",20000);
        String result = account.generateBankStatement();

        Assertions.assertEquals("date       || credit  || debit  || balance\n15-04-21 ||         || 200.00 || 200.00\n",result);

    }
}
