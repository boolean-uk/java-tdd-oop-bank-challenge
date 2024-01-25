package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class BankStatementTest {

    @Test
    public void initBankStatement() {

        Date date = new Date();
        BankStatement bankStatement = new BankStatement(500.00, 2000.00) {
            @Override
            protected String getStatementAsString() {
                return "";
            }
        };

        Assertions.assertEquals(2000,bankStatement.getBalance());
        Assertions.assertEquals(500,bankStatement.getAmount());
        Assertions.assertEquals(date,bankStatement.getTransactionDate());
    }


}
