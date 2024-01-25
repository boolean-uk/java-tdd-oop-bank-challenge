package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankStatementTest {

    @Test
    public void generateBankStatement() {
        BankStatement bankStatement = new BankStatement();

        String expectedBankStatement = "";

        String actualBankStatement = bankStatement.generateBankStatement();

        Assertions.assertEquals(expectedBankStatement, actualBankStatement);
    }
}
