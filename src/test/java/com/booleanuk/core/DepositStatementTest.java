package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DepositStatementTest {

    @Test
    public void testDepositStatementInit() {
        Date date = new Date();

        BankStatement depositStatement = new DepositStatement(date, 500, 2000);


        Assertions.assertEquals(date, depositStatement.getTransactionDate());
        Assertions.assertEquals(500, depositStatement.getAmount());
        Assertions.assertEquals(0, depositStatement.getBalance());
        Assertions.assertEquals("", depositStatement.getStatementAsString());
    }


}
