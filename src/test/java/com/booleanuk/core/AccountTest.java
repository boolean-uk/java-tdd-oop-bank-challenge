package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    //User story 3
    @Test
    public void generatedBankStatementShouldHaveAllTransactions() {
        Account account = new Account(123, new BankStatementGenerator());
        account.deposit(100);
        account.withdraw(50);
        String actualBankStatement = account.getBankStatement();
        String expectedBankStatement =
                "Credit: 100 on 10/01/2024" + "/n" +
                "Debit: 50 on 15/01/2024" + "/n" +
                "Balance: 50";
        Assertions.assertEquals(actualBankStatement, expectedBankStatement);
    }
}
