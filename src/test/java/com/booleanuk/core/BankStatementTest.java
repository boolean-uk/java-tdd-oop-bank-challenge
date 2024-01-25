package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BankStatementTest {

    @Test
    public void generateBankStatement() {
        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String formattedDate = dateFormat.format(date);

        BankStatement bankStatement = new BankStatement(formattedDate, 100.00, 50.00);

        BankAffiliate bankAffiliate = new BankAffiliate("James Bond", "Bank Customer");

        String expectedBankStatement = "";

        String actualBankStatement = bankStatement.generateBankStatement(bankAffiliate);

        Assertions.assertEquals(expectedBankStatement, actualBankStatement);
    }
}
