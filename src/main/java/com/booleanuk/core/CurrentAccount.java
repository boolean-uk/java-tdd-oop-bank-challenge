package com.booleanuk.core;

public class CurrentAccount extends Account {
  public CurrentAccount(Branch branch) {
    super(branch);
  }

  public CurrentAccount(Branch branch, int deposit) {
    super(branch, deposit);
  }
}
