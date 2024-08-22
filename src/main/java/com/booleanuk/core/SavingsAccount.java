package com.booleanuk.core;

import java.util.ArrayList;

// Specificiation does not say anything about what the difference is between account types so SavingsAccount is just the same as a CurrentAccount
public class SavingsAccount extends CurrentAccount {
  public SavingsAccount() {
    this(0);
  }

  public SavingsAccount(int deposit) {
    this.balance = deposit;
    this.transactions = new ArrayList<>();
  }
}
