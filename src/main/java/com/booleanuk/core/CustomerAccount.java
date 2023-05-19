package com.booleanuk.core;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

enum ACCOUNTTYPE {
    CREDIT,
    SAVINGS
}

enum BALANCETYPE {
    NOERROR,
    NOBALANCE,
    ZEROBALANCE
}

public class CustomerAccount extends BankAccount {
    final private ACCOUNTTYPE type;
    private BALANCETYPE balanceType;

    public ACCOUNTTYPE getType() {
        return type;
    }
    public CustomerAccount(ACCOUNTTYPE type, String accountName, String branch) {
        this.type = type;
        this.statements = new ArrayList<>();
        this.balanceType = BALANCETYPE.NOERROR;
        this.accountName = accountName;
        this.branch = branch;
    }

    @Override
    public boolean withdraw(double withdraw) {
        if (!this.isOverdraft()) {
            if (!checkBalance(withdraw)) return false;
        }
        BankStatement bankStatement = new BankStatement();
        double previousBalance = this.getBalance();
        bankStatement.withdraw(withdraw, previousBalance);
        statements.add(bankStatement);
        this.balanceType = BALANCETYPE.NOERROR;
        return true;
    }


    @Override
    public boolean deposit(double deposit) {
        BankStatement bankStatement = new BankStatement();
        double previousBalance = this.getBalance();
        bankStatement.deposit(deposit, previousBalance);
        statements.add(bankStatement);
        this.balanceType = BALANCETYPE.NOERROR;
        return true;
    }

    @Override
    public String printStatements(BankAccount account) {
        StringBuilder sb = new StringBuilder();
        for (int i = account.statements.size() - 1; i >= 0; i--) {
            sb.append(account.statements.get(i) + "\n");
        }
        return sb.toString().trim();
    }

    @Override
    public void changeOverdraft() {
        this.overdraft = new Random().nextBoolean();
    }

    private boolean checkBalance(double withdraw) {
        if (statements.size() > 0) {
            if (this.getBalance() > withdraw) {
                this.balanceType = BALANCETYPE.NOERROR;
                return true;
            }
        }
        this.balanceType = BALANCETYPE.NOBALANCE;
        return false;
    }

    public double getBalance() {
        if (statements.size() == 0) {
            this.balanceType=BALANCETYPE.NOBALANCE;
            return 0;
        }
        this.balanceType=BALANCETYPE.NOERROR;
        return this.statements.get(statements.size() - 1).getBalance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAccount that = (CustomerAccount) o;
        return type == that.type && Objects.equals(branch, that.branch) && Objects.equals(accountName, that.accountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, accountName, branch);
    }
}
