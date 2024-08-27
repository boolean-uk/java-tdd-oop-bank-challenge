package com.booleanuk.core;

public class OverdraftException extends RuntimeException {
  private Account account;
  private int amount;

  public OverdraftException(int balance, int amount, Account account) {
    super("Account attempted to overdraft " + amount + " with a balance of " + balance);
    this.account = account;
    this.amount = amount;
  }

  public void accept() {
    this.account.forceWithdraw(this.amount);
  }

  public void decline() {
    // Don't really need to do anything I suppose
  }
}
