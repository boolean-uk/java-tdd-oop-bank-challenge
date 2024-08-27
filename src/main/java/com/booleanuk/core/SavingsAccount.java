package com.booleanuk.core;

import java.time.LocalDateTime;

// Specificiation does not say anything about what the difference is between account types so SavingsAccount is just the same as a CurrentAccount
public class SavingsAccount extends Account {
  public SavingsAccount(Branch branch) {
    super(branch);
  }

  public SavingsAccount(Branch branch, int deposit) {
    super(branch, deposit);
  }

  @Override
  public void withdraw(int amount) {
    this.withdraw(amount, LocalDateTime.now());
  }

  @Override
  public void withdraw(int amount, LocalDateTime time) {
    int balance = this.balance();
    if (balance - amount < 0)
      throw new CantOverdraftException(this);

    this.transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL, time));

  }
}
