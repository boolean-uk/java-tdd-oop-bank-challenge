package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BankStatementTest {
    @Test
    public void testPrintStatement() {
        BankStatement bankStatement = new BankStatement();
        Account account = new CurrentAccount();

        account.deposit(new BigDecimal("1000"));
        account.deposit(new BigDecimal("2000"));
        account.withdraw(new BigDecimal("500"));

        System.out.println("Current Account Statement:");
        bankStatement.printStatement(account);
    }
}
