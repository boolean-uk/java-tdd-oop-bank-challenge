package com.booleanuk.core;

import java.util.*;

public abstract class Account {
    private String accountId;
    private int balance;
    private String branchId;
    private HashMap<Date,Statement> statements;
    AccountsList accountsList = new AccountsList();

    public Account(String branchId) {
        this.branchId = branchId;
        statements = new HashMap<>();
        this.accountId = accountsList.generateAccountId(this.branchId);
    }

    public String getAccountId() {
        return this.accountId;
    }

    public double getBalance() {
        return (double) (this.balance / 100.00);
    }

    public void setBalance() {
        int updatedBalance = 0;
        for (Statement statement: this.statements.values()){
            updatedBalance += (int) (statement.getAmount() * 100);
        }
        this.balance = updatedBalance;
    }

    public boolean deposit(double amount){
        int balance = this.balance;
        balance += (int) (amount * 100);
        Statement statement = new Statement(amount, balance);
        this.statements.put(statement.getDate(),statement);
        setBalance();
        return true;
    }

    public boolean withdraw(double amount) {
        int balance = this.balance;
        int amountInt = (int) (amount * 100);
        if (balance > amountInt || overdraft(amountInt)) {
            balance -= (int) (amount * 100);
            Statement statement = new Statement(-amount, balance);
            this.statements.put(statement.getDate(), statement);
            setBalance();
            return true;
        } else {
            return false;
        }
    }

    /**
     * User Stories 7,8 (Extensions) An overdraft will be allowed for amounts less than
     * the 10% of the total of previous deposited statements.
     * @param amountInt
     * @return
     */
    public boolean overdraft(int amountInt) {
        int depostitTotal = 0;
        for (Statement statement: statements.values()) {
            if (statement.getAmount() > 0) {
                depostitTotal += (int) (statement.getAmount() * 100);
            }
        }
        if (depostitTotal/10 >= amountInt - this.balance) {
            return true;
        }else {
            return false;
        }
    }

    public String getStatements() {
        String statementsString = "";
        ArrayList<Date> datesList = new ArrayList<>();
        datesList.addAll(statements.keySet());
        Collections.sort(datesList,Collections.reverseOrder());
        for (Date date: datesList) {
            statementsString += "\n" + statements.get(date).toString();
        }
        return statementsString;
    }

    @Override
    public String toString() {
        return "Account " + accountId + "\nBalance: " + balance;
    }
}
