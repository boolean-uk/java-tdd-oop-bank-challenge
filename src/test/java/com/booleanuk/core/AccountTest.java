package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class AccountTest {
    @Test
    public void testCreatingStatement() {
        Bank bank = new Bank();
        UUID customerId = bank.registerCustomer();
        UUID accountId = bank.openAccount(customerId, CurrentAccount.class);
        Account account = bank.getAccounts().get(accountId);
        List<Transaction> transactions = account.getTransactions();
        transactions.add(new Transaction(LocalDateTime.of(2012, 1, 14, 0, 0, 0), null, BigDecimal.valueOf(1_000), BigDecimal.valueOf(1_000)));
        transactions.add(new Transaction(LocalDateTime.of(2023, 1, 13, 0, 0, 0), null, BigDecimal.valueOf(2_000), BigDecimal.valueOf(3_000)));
        transactions.add(new Transaction(LocalDateTime.of(2023, 1, 10, 0, 0, 0), BigDecimal.valueOf(500), null, BigDecimal.valueOf(2_500)));
        String statement = account.generateStatement();
        Assertions.assertTrue(statement.contains("      date ||     credit ||      debit ||    balance"));
        Assertions.assertTrue(statement.contains("13/01/2023 ||            ||    2000,00 ||    3000,00"));
        Assertions.assertTrue(statement.contains("10/01/2023 ||     500,00 ||            ||    2500,00"));
        Assertions.assertTrue(statement.contains("14/01/2012 ||            ||    1000,00 ||    1000,00"));
    }
}
