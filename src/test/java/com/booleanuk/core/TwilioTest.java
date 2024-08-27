package com.booleanuk.core;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TwilioTest {
  @Disabled
  @Test
  public void testNotifyUser() {
    Account account = new CurrentAccount(Branch.OSLO);

    LocalDateTime firstDepositDate = LocalDateTime.of(2012, 1, 10, 0, 0);
    LocalDateTime secondDepositDate = LocalDateTime.of(2012, 1, 13, 0, 0);
    LocalDateTime firstWithdrawDate = LocalDateTime.of(2012, 1, 14, 0, 0);
    account.deposit(1000, firstDepositDate);
    account.deposit(2000, secondDepositDate);
    account.withdraw(500, firstWithdrawDate);

    String history = account.getHistory();

    MessageController.notifyUser(history, "<some phone number>");

  }
}
