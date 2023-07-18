package com.booleanuk.core;

public class CurrentAccount extends Account{
    private final static int OVERDRAFTLIMIT = 50000;
    public CurrentAccount(String accountNr, Branch branch) {
        super(accountNr, branch);
    }

    public boolean overdraft(int amountOfMoney) {
        if (calculateBalance() - amountOfMoney < 0 && Math.abs(calculateBalance() - amountOfMoney) > OVERDRAFTLIMIT) throw new IllegalStateException("Overdraft!");
        else return false;
    }

    @Override
    public void withdraw(int amountOfMoney) {
        if (!overdraft(amountOfMoney)) super.withdraw(amountOfMoney);
    }
}
