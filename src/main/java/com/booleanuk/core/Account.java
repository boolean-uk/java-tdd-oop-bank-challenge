package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {
    //protected final String branch;
    protected final String accountName;
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    private final double maxBalance;

    protected boolean isOverdraft;

    private int currentWithdrawalCount;

    public Account(String accountName, double maxBalance) {
        this.accountName = accountName;
        this.maxBalance = maxBalance;
    }

    protected abstract int monthlyMaxWithdrawalCount();

    protected double getBalance() {
        double _outBalance = 0.0;
        for (Transaction t : transactions) {
            switch (t.getType()) {
                case DEPOSIT -> _outBalance += t.getCredit();
                case WITHDRAW -> _outBalance -= t.getCredit();
            }
        }
        return _outBalance;
    }

    public Status deposit(double credit) {
        if (credit <= 0.0) return Status.INVALID_NUMBER;
        if (getBalance() + credit > maxBalance) return Status.EXCEEDED_BALANCE;

        transactions.add(new Transaction(credit));

        return Status.OK;
    }

    public Status withdraw(double debit) {
        if (debit <= 0.0) return Status.INVALID_NUMBER;
        if (monthlyMaxWithdrawalCount() > 0 && hasExceededMonthlyWithdrawal()) return Status.EXCEEDED_WITHDRAWAL_AMOUNT;
        if (getBalance() - debit < 0.0 && !isOverdraft) return Status.BALANCE_TOO_SMALL;

        currentWithdrawalCount++;
        transactions.add(new Transaction(-debit));

        return Status.OK;
    }

    public TransactionStatement[] getBankStatement() {
        TransactionStatement[] _outTransactions = new TransactionStatement[transactions.size()];
        double _balanceTracker = 0.0;

        for (int i = 0; i < _outTransactions.length; i++) {
            Transaction _t = transactions.get(i);
            switch (_t.getType()) {
                case DEPOSIT -> _balanceTracker += _t.getCredit();
                case WITHDRAW -> _balanceTracker -= _t.getCredit();
            }
            _outTransactions[transactions.size() - i - 1] = new TransactionStatement(_t.getCredit(), _balanceTracker, _t.getDate(), _t.getType());
        }

        return _outTransactions;
    }

    public boolean hasExceededMonthlyWithdrawal() {
        return monthlyMaxWithdrawalCount() <= currentWithdrawalCount;
    }
}
