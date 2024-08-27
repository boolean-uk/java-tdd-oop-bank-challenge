package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
  protected List<Transaction> transactions;
  protected Branch branch;

  public Account(Branch branch) {
    this.transactions = new ArrayList<>();
    this.branch = branch;
  }

  public Account(Branch branch, int deposit) {
    this(branch);
    this.transactions.add(new Transaction(deposit, TransactionType.DEPOSIT, LocalDateTime.now()));
  }

  public Branch branch() {
    return this.branch;
  }

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

  public void deposit(int amount) {
    this.deposit(amount, LocalDateTime.now());
  }

  public void deposit(int amount, LocalDateTime time) {
    this.transactions.add(new Transaction(amount, TransactionType.DEPOSIT, time));
  }

  public void withdraw(int amount) throws OverdraftException {
    this.withdraw(amount, LocalDateTime.now());
  }

  public void withdraw(int amount, LocalDateTime time) throws OverdraftException {
    int balance = this.balance();
    if (balance - amount < 0)
      throw new OverdraftException(balance, amount, this);

    this.transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL, time));
  }

  public void forceWithdraw(int amount) {
    this.forceWithdraw(amount, LocalDateTime.now());
  }

  public void forceWithdraw(int amount, LocalDateTime time) {
    System.out.println("alksdlkalskd " + this.balance());
    this.transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL, time));
    System.out.println("alksdlkalskd2222 " + this.balance());
  }

  public String getHistory() {
    StringBuilder history = new StringBuilder();
    history.append(String.format("|| %-20s|| %-10s|| %-10s|| %-10s||\n", "date", "credit", "debit", "balance"));

    for (int i = this.transactions.size() - 1; i >= 0; --i) {
      Transaction transaction = this.transactions.get(i);
      history.append(transaction.toStringWithBalance(this.balance(i)));
    }

    return history.toString();
  }
}
