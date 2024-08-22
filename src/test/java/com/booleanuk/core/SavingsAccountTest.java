package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
  @Test
  public void testWithdraw() {
    Account account = new SavingsAccount(Branch.OSLO, 100);

    account.withdraw(50);
    Assertions.assertEquals(50, account.balance());

    account.withdraw(20);
    Assertions.assertEquals(30, account.balance());
  }

  @Test
  public void testDeposit() {
    Account account = new SavingsAccount(Branch.OSLO, 100);

    account.deposit(50);
    Assertions.assertEquals(150, account.balance());

    account.deposit(20);
    Assertions.assertEquals(170, account.balance());
  }

  @Test
  public void testWithdrawDeposit() {
    Account account = new SavingsAccount(Branch.OSLO, 100);

    account.withdraw(50);
    Assertions.assertEquals(50, account.balance());

    account.deposit(50);
    Assertions.assertEquals(100, account.balance());
  }
}
