package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class WithdrawStatementTest {

    @Test
    public void testDepositStatementInit() {
        Date date = new Date();

        BankStatement withdrawStatement = new WithdrawStatement(date, 500, 2000);


        Assertions.assertEquals(date, withdrawStatement.getTransactionDate());
        Assertions.assertEquals(500, withdrawStatement.getAmount());
        Assertions.assertEquals(0, withdrawStatement.getBalance());
        Assertions.assertEquals("", withdrawStatement.getStatementAsString());

    }
}
