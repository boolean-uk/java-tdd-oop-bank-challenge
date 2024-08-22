package com.booleanuk.core;

public class OverdraftException extends RuntimeException {
  public OverdraftException(int balance, int amount) {
    super("Account attempted to overdraft " + amount + " with a balance of " + balance);
  }

  public void accept() {
  }

  public void decline() {
  }
}
