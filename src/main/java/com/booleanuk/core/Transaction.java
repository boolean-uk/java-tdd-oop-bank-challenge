package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Transaction(int amount, TransactionType type, LocalDateTime time) {
  public String toStringWithBalance(int balance) {
    String timeString = this.time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    switch (this.type) {
      case DEPOSIT:
        return String.format("|| %-20s|| %-10s|| %-10d|| %-10d||\n", timeString, "", amount, balance);

      case WITHDRAWAL:
        return String.format("|| %-20s|| %-10s|| %-10s|| %-10s||\n", timeString, amount, "", balance);
    }

    throw new RuntimeException("Unknown transaction type");
  }
}
