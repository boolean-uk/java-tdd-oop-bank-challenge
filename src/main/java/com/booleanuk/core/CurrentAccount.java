package com.booleanuk.core;

public class CurrentAccount implements Account {
  private int balance;

  public CurrentAccount() {
    this.balance = 0;
  }

  public CurrentAccount(int deposit) {
    this.balance = deposit;
  }

  @Override
  public int balance() {
    return this.balance;
  }

  @Override
  public void deposit(int amount) {
    this.balance += amount;
  }

  @Override
  public void withdraw(int amount) {
    this.balance -= amount;
  }

  @Override
  public String getHistory() {
    throw new UnsupportedOperationException("Unimplemented method 'getHistory'");
  }
}
