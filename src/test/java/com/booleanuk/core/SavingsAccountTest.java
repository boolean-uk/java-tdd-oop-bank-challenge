package com.booleanuk.core;

import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
  @Test
  public void testCannotOverdraft() {
    Account account = new SavingsAccount(Branch.OSLO);
    account.deposit(200);
    Assertions.assertDoesNotThrow(() -> account.withdraw(200));
    Assertions.assertThrows(CantOverdraftException.class, () -> account.withdraw(200));
  }
}
