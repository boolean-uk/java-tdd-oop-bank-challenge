package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CurrentAccount implements Account {
  protected List<Transaction> transactions;
  protected int balance;

  public CurrentAccount() {
    this(0);
  }

  public CurrentAccount(int deposit) {
    this.balance = deposit;
    this.transactions = new ArrayList<>();
  }

  @Override
  public int balance() {
    return this.balance;
  }

  @Override
  public void deposit(int amount) {
    this.deposit(amount, LocalDateTime.now());
  }

  @Override
  public void deposit(int amount, LocalDateTime time) {
    this.balance += amount;
    this.transactions.add(new Transaction(amount, this.balance, TransactionType.DEPOSIT, time));
  }

  @Override
  public void withdraw(int amount) {
    this.withdraw(amount, LocalDateTime.now());
  }

  @Override
  public void withdraw(int amount, LocalDateTime time) {
    this.balance -= amount;
    this.transactions.add(new Transaction(amount, this.balance, TransactionType.WITHDRAWAL, time));
  }

  @Override
  public String getHistory() {
    StringBuilder history = new StringBuilder();
    history.append("\n");

    String tableLabels = "date || credit || debit || balance";
    String[] columns = tableLabels.split("\\s*\\|\\|\\s*");
    int[] columnWidths = { 20, 10, 10, 10 };

    for (int i = 0; i < columns.length; i++) {
      String centered = String.format("%-" + columnWidths[i] + "s",
          String.format("%" + ((columnWidths[i] + columns[i].length()) / 2) + "s", columns[i]));
      history.append("|| ").append(centered.substring(0, columnWidths[i])).append(" ");
    }

    history.append("||\n");

    for (Transaction transaction : this.transactions.reversed())
      history.append(transaction);

    return history.toString();
  }
}
