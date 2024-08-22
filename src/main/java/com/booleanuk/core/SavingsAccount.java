package com.booleanuk.core;

public class SavingsAccount implements Account {
  private int balance;

  public SavingsAccount() {
    this.balance = 0;
  }

  public SavingsAccount(int deposit) {
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
