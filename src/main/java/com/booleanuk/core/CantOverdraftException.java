package com.booleanuk.core;

public class CantOverdraftException extends RuntimeException {
  public CantOverdraftException(Account account) {
    super("Cannot overdraft on account of type " + account.getClass());
  }
}
