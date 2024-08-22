package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CurrentAccount implements Account {
  private List<Transaction> transactions;
  private int balance;

  public CurrentAccount() {
    this.transactions = new ArrayList<>();
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
    this.deposit(amount, LocalDateTime.now());
  }

  @Override
  public void deposit(int amount, LocalDateTime time) {
    this.balance += amount;
    this.transactions.add(new Transaction(amount, TransactionType.DEPOSIT, LocalDateTime.now()));
  }

  @Override
  public void withdraw(int amount) {
    this.withdraw(amount, LocalDateTime.now());
  }

  @Override
  public void withdraw(int amount, LocalDateTime time) {
    this.balance -= amount;
    this.transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL, LocalDateTime.now()));
  }

  @Override
  public String getHistory() {
    StringBuilder history = new StringBuilder();
    history.append("date       || credit  || debit  || balance");

    for (Transaction transaction : this.transactions)
      history.append(transaction); // .toString() ?

    return history.toString();
  }
}
