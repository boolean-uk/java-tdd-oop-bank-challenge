package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class AccountTest {
    @BeforeEach
    public void setup() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @Test
    public void testCreatingStatement() {
        Bank bank = new Bank();
        UUID customerId = bank.registerCustomer();
        UUID accountId = bank.openAccount(customerId, CurrentAccount.class);
        Account account = bank.getAccounts().get(accountId);
        List<Transaction> transactions = account.getTransactions();
        transactions.add(new Transaction(LocalDateTime.of(2012, 1, 14, 0, 0, 0), BigDecimal.valueOf(1_000), null));
        transactions.add(new Transaction(LocalDateTime.of(2012, 1, 13, 0, 0, 0), BigDecimal.valueOf(2_000), null));
        transactions.add(new Transaction(LocalDateTime.of(2012, 1, 10, 0, 0, 0), null, BigDecimal.valueOf(500)));
        String statement = account.generateStatement();

        Assertions.assertTrue(statement.contains("      date ||     credit ||      debit ||    balance"));
        Assertions.assertTrue(statement.contains("14/01/2012 ||    1000.00 ||            ||    1000.00"));
        Assertions.assertTrue(statement.contains("13/01/2012 ||    2000.00 ||            ||    3000.00"));
        Assertions.assertTrue(statement.contains("10/01/2012 ||            ||     500.00 ||    2500.00"));
    }

    @Test
    public void testDepositingFunds() {
        Bank bank = new Bank();
        UUID customerId = bank.registerCustomer();
        UUID accountId = bank.openAccount(customerId, CurrentAccount.class);
        Account account = bank.getAccounts().get(accountId);
        account.deposit(BigDecimal.valueOf(1_000));
        Assertions.assertEquals(BigDecimal.valueOf(1_000), account.getBalance());
    }

    @Test
    public void testWithdrawingFunds() {
        Bank bank = new Bank();
        UUID customerId = bank.registerCustomer();
        UUID accountId = bank.openAccount(customerId, CurrentAccount.class);
        Account account = bank.getAccounts().get(accountId);
        account.deposit(BigDecimal.valueOf(1_000));
        account.withdraw(BigDecimal.valueOf(500));
        Assertions.assertEquals(BigDecimal.valueOf(500), account.getBalance());
    }

    @Test
    public void testCalculatingBalanceViaTransactionHistory() {
        Bank bank = new Bank();
        UUID customerId = bank.registerCustomer();
        UUID accountId = bank.openAccount(customerId, CurrentAccount.class);
        bank.deposit(accountId, BigDecimal.valueOf(1_000));
        bank.deposit(accountId, BigDecimal.valueOf(2_000));
        bank.withdraw(customerId, accountId, BigDecimal.valueOf(2_500));
        Account account = bank.getAccounts().get(accountId);

        Assertions.assertEquals(BigDecimal.valueOf(500), account.getBalance());
    }
}
