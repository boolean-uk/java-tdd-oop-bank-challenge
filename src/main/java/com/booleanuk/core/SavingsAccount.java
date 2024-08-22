package com.booleanuk.core;

// Specificiation does not say anything about what the difference is between account types so SavingsAccount is just the same as a CurrentAccount
public class SavingsAccount extends CurrentAccount {
  public SavingsAccount() {
    super();
  }

  public SavingsAccount(int deposit) {
    super(deposit);
  }
}
