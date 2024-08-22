package com.booleanuk.core;

import java.time.LocalDateTime;

public record Transaction(int amount, TransactionType type, LocalDateTime time) {
  @Override
  public String toString() {
    return "";
  }
}
