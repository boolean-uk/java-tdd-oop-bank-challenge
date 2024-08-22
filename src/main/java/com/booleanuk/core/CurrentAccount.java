package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CurrentAccount implements Account {
  protected List<Transaction> transactions;

  public CurrentAccount() {
    this.transactions = new ArrayList<>();
  }

  public CurrentAccount(int deposit) {
    this();
    this.transactions.add(new Transaction(deposit, TransactionType.DEPOSIT, LocalDateTime.now()));
  }

  @Override
  public int balance() {
    return this.balance(this.transactions.size() - 1);
  }

  private int balance(int nTransactions) {
    int balance = 0;
    for (int i = 0; i <= nTransactions; ++i) {
      Transaction transaction = this.transactions.get(i);
      if (transaction.type() == TransactionType.DEPOSIT)
        balance += transaction.amount();
      else if (transaction.type() == TransactionType.WITHDRAWAL)
        balance -= transaction.amount();
    }

    return balance;
  }

  @Override
  public void deposit(int amount) {
    this.deposit(amount, LocalDateTime.now());
  }

  @Override
  public void deposit(int amount, LocalDateTime time) {
    this.transactions.add(new Transaction(amount, TransactionType.DEPOSIT, time));
  }

  @Override
  public void withdraw(int amount) {
    this.withdraw(amount, LocalDateTime.now());
  }

  @Override
  public void withdraw(int amount, LocalDateTime time) {
    this.transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL, time));
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

    for (int i = this.transactions.size() - 1; i >= 0; --i) {
      Transaction transaction = this.transactions.get(i);
      history.append(transaction.toStringWithBalance(this.balance(i)));
    }

    return history.toString();
  }
}
