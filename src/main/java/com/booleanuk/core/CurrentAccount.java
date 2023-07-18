package com.booleanuk.core;

public class CurrentAccount extends Account{
    private final static int OVERDRAFTLIMIT = 50000;
    public CurrentAccount(String accountNr, Branch branch) {
        super(accountNr, branch);
    }

    public boolean overdraft() {
        if (calculateBalance() < OVERDRAFTLIMIT) throw new IllegalStateException("Overdraft!");
        else return false;
    }

    @Override
    public void withdraw(int amountOfMoney) {
        if (!overdraft()) super.withdraw(amountOfMoney);
    }
}
