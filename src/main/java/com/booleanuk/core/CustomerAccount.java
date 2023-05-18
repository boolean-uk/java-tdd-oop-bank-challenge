package com.booleanuk.core;


import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

enum ACCOUNTTYPE {
    CREDIT,
    SAVINGS
}

enum BALANCETYPE {
    NOCODE,
    NOBALANCE
}

public class CustomerAccount extends BankAccount {
    final private ACCOUNTTYPE type;
    private BALANCETYPE balanceType;

    public ACCOUNTTYPE getType() {
        return type;
    }

    public CustomerAccount(ACCOUNTTYPE type) {
        this.type = type;
        this.statements = new ArrayList<>();
        this.balanceType = BALANCETYPE.NOCODE;
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
        this.balanceType = BALANCETYPE.NOCODE;
        return true;
    }



    @Override
    public boolean deposit(double deposit) {
        BankStatement bankStatement = new BankStatement();
        double previousBalance = this.getBalance();
        bankStatement.deposit(deposit, previousBalance);
        statements.add(bankStatement);
        this.balanceType = BALANCETYPE.NOCODE;
        return true;
    }

    @Override
    public String printStatements(BankAccount account) {
        StringBuilder sb =new StringBuilder();
        for (int i = account.statements.size() - 1; i >= 0; i--) {
            sb.append(account.statements.get(i)+"\n");
//            System.out.println(account.statements.get(i).toString());
        }
        return sb.toString().trim();
    }
    @Override
    public void changeOverdraft() {
        Random rd = new Random(); // creating Random object
        this.overdraft=rd.nextBoolean();
    }



    private boolean checkBalance(double withdraw) {
        if (statements.size() > 0) {
            if (this.getBalance() > withdraw) {
                this.balanceType = BALANCETYPE.NOCODE;
                return true;
            }
        }
        this.balanceType = BALANCETYPE.NOBALANCE;
        return false;
    }

    public double getBalance() {
        if (statements.size()==0){
            return 0;
        }
        return this.statements.get(statements.size() - 1).getBalance();
    }
}
