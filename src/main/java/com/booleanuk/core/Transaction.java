package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Transaction(int amount, TransactionType type, LocalDateTime time) {
  public String toStringWithBalance(int balance) {
    // This is just some garbage AI generated code for formating the strings. Should
    // probably clean it up and improve it
    String[] columns = new String[4];
    columns[0] = this.time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    columns[3] = String.valueOf(balance);

    switch (this.type) {
      case DEPOSIT:
        columns[1] = String.valueOf(amount);
        columns[2] = "";
        break;

      case WITHDRAWAL:
        columns[1] = "";
        columns[2] = String.valueOf(amount);
        break;

      default:
        throw new RuntimeException("Unknown transaction type");
    }

    int[] columnWidths = { 20, 10, 10, 10 };
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < columns.length; i++) {
      String centered = String.format("%-" + columnWidths[i] + "s",
          String.format("%" + ((columnWidths[i] + columns[i].length()) / 2) + "s", columns[i]));
      result.append("|| ").append(centered.substring(0, columnWidths[i])).append(" ");
    }

    result.append("||\n");
    return result.toString();
  }
}
