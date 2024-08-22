package com.booleanuk.core;

import java.time.LocalDateTime;

public interface Account {
  int balance();

  void deposit(int amount);

  void deposit(int amount, LocalDateTime time);

  void withdraw(int amount);

  void withdraw(int amount, LocalDateTime time);

  void forceWithdraw(int amount);

  void forceWithdraw(int amount, LocalDateTime time);

  String getHistory();

  Branch branch();
}
