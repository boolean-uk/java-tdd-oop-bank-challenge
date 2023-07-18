package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankStatementGeneratorTest {

    @Test
    public void generateBankStatementTest() {
        CurrentAccount currentAccount =
                new CurrentAccount();
        currentAccount.deposit(4000);
        currentAccount.deposit(3200);
        currentAccount.deposit(500);
        currentAccount.withdraw(2563);
        currentAccount.deposit(235600);

        BankStatementGenerator bankStatementGenerator =
                new BankStatementGenerator();

        String expectedBankStatement = """
                date       || credit  || debit || balance
                18/07/2023 || 2356.00 ||       || 2407.37
                18/07/2023 ||         || 25.63 || 51.37 \s
                18/07/2023 || 5.00    ||       || 77.00 \s
                18/07/2023 || 32.00   ||       || 72.00 \s
                18/07/2023 || 40.00   ||       || 40.00 \s""";

        assertEquals(
                expectedBankStatement,
                bankStatementGenerator.generateBankStatement(
                        currentAccount.getTransactions()
                )
        );

        System.out.println(bankStatementGenerator.generateBankStatement(
                currentAccount.getTransactions()
        ));
    }
}
