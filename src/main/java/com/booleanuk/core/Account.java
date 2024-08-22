package com.booleanuk.core;

public interface Account {
  int balance();

  void deposit(int amount);

  void withdraw(int amount);

  String getHistory();
}
