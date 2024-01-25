package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankStatementGeneratorTest {

    //User story 3
    @Test
    public void generatedBankStatementShouldHaveAllTransactions() {
        BankStatementGenerator bankStatementGenerator = new BankStatementGenerator();

        Transaction depositTransaction = new Transaction("credit", "10/01/2024", 100, 100);
        Transaction withdrawTransaction = new Transaction("debit", "15/01/2024", 50, 50);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(depositTransaction);
        transactions.add(withdrawTransaction);

        String actualBankStatement = bankStatementGenerator.generateBankStatement(transactions);

        String expectedBankStatement =
                        "Date Credit Debit Balance" + "/n" +
                        "10/01/2024 100.0 0 100.0" + "/n" +
                        "15/01/2024 0 50.0 50.0";

        Assertions.assertEquals(expectedBankStatement, actualBankStatement);
    }
}
