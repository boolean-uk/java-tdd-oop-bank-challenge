package com.booleanuk.extension;

public class CurrentAccount extends BankAccount{

    public CurrentAccount(String branchCode, String userPhoneNumber) {
        super(branchCode, userPhoneNumber);
    }

    @Override
    public boolean withdraw(int amount) {
        int overdraftLimit = Bank.getBranch(getBranchCode())
                .overdraftLimit();

        if (amount <= 0 || Math.abs(getCurrentBalance() - amount) > overdraftLimit)
            return false;

        transactions.add(new Transaction(amount, false));
        return true;
    }
}
