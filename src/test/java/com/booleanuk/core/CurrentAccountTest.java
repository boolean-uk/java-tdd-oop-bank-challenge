package com.booleanuk.core;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sun.util.resources.cldr.CurrencyNames;

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
    Account account = new CurrentAccount();

    LocalDateTime firstDepositDate = LocalDateTime.of(2012, 01, 10, 0, 0);
    LocalDateTime secondDepositDate = LocalDateTime.of(2012, 01, 13, 0, 0);
    LocalDateTime firstWithdrawDate = LocalDateTime.of(2012, 01, 14, 0, 0);
    account.deposit(1000, firstDepositDate);
    account.deposit(2000, secondDepositDate);
    account.withdraw(500, firstWithdrawDate);

    String history = account.getHistory();

    Assertions.assertTrue(history.contains("||         date         ||   credit   ||   debit    ||  balance   ||"));
    Assertions.assertTrue(history.contains("|| 2012-01-14 00:00:00  ||            ||    500     ||    2500    ||"));
    Assertions.assertTrue(history.contains("|| 2012-01-13 00:00:00  ||    2000    ||            ||    3000    ||"));
    Assertions.assertTrue(history.contains("|| 2012-01-10 00:00:00  ||    1000    ||            ||    1000    ||"));
  }

  @Test
  public void testBranch() {
    Account osloAccount = new CurrencyNames(Branch.OSLO);
    Assertions.assertEquals(osloAccount.branch(), Branch.OSLO);

    Account karlskronaAccount = new CurrencyNames(Branch.KARLSKRONA);
    Assertions.assertEquals(karlskronaAccount.branch(), Branch.KARLSKRONA);
  }
}
