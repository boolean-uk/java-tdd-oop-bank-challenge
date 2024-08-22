package com.booleanuk.core;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CurrentAccountTest {
  @Test
  public void testWithdraw() {
    Account account = new CurrentAccount(100);

    account.withdraw(50);
    Assertions.assertEquals(50, account.balance());

    account.withdraw(20);
    Assertions.assertEquals(30, account.balance());
  }

  @Test
  public void testDeposit() {
    Account account = new CurrentAccount(100);

    account.deposit(50);
    Assertions.assertEquals(150, account.balance());

    account.deposit(20);
    Assertions.assertEquals(170, account.balance());
  }

  @Test
  public void testWithdrawDeposit() {
    Account account = new CurrentAccount(100);

    account.withdraw(50);
    Assertions.assertEquals(50, account.balance());

    account.deposit(50);
    Assertions.assertEquals(100, account.balance());
  }

  @Test
  public void testHistory() {
    Account account = new CurrentAccount(100);
    account.deposit(1000, LocalDateTime.of(2012, 01, 10, 0, 0));
    account.deposit(200, LocalDateTime.of(2012, 01, 13, 0, 0));
    account.withdraw(500, LocalDateTime.of(2012, 01, 14, 0, 0));

    String history = account.getHistory();
    Assertions.assertTrue(history.contains("date       || credit  || debit  || balance"));
    Assertions.assertTrue(history.contains("14/01/2012 ||         || 500.00 || 2500.00"));
    Assertions.assertTrue(history.contains("13/01/2012 || 2000.00 ||        || 3000.00"));
    Assertions.assertTrue(history.contains("10/01/2012 || 1000.00 ||        || 1000.00"));
  }
}
